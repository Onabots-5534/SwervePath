package frc.robot.Subsystems;

// import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityDutyCycle;
// import com.ctre.phoenix6.controls.VelocityTorqueCurrentFOC;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SubSwerve extends SubsystemBase {

    public TalonFX
      Drive,
      Steer;

    public CANcoder
      Encod;

    public VelocityVoltage m_VelocityVoltage = new VelocityVoltage( 0, 0, false, 0, 0, false, false, false ); // Slot 0

    // public VelocityDutyCycle m_

    public PositionVoltage m_PositionVoltage = new PositionVoltage( 0, 0, false, 0, 1, false, false, false ); // Slot 1

    public SubSwerve( int[] ID ) {
      Drive = new TalonFX ( ID[0] );
      Steer = new TalonFX ( ID[1] );
      Encod = new CANcoder( ID[2] );

      // TalonFXConfiguration configs = new TalonFXConfiguration();
      
      // /* VOLTAGE BASED VELOCITY */
      // configs.Slot0.kP = 0.10; // An error of 1 rev/sec => 2V output
      // configs.Slot0.kI = 0.00; //
      // configs.Slot0.kD = 0.00; //
      // configs.Slot0.kV = 0.12; //

      // /* POSITION CONTROL */
      // configs.Slot1.kP = 0.10; //
      // configs.Slot1.kI = 0.00; //
      // configs.Slot1.kD = 0.00; //
      // configs.Slot1.kV = 0.05; //

      // configs.CurrentLimits.StatorCurrentLimit       = 40;
      // configs.CurrentLimits.StatorCurrentLimitEnable = true;

      // configs.Voltage.PeakForwardVoltage =  8;
      // configs.Voltage.PeakReverseVoltage = -8;

      // // configs.TorqueCurrent.PeakForwardTorqueCurrent =  40;
      // // configs.TorqueCurrent.PeakReverseTorqueCurrent = -40;

      // Drive.getConfigurator().apply( configs );
      // Steer.getConfigurator().apply( configs );
    }

// TODO: Consider dropping support for the built-in PID controller and instead go back to using my own.
// This requires more testing to see if I can get it to work. Remember that I also need to implement the
// flipper. Check if this is too high to move under the hanging chain.

// PROBLEM: Velocity control seems to work ok but I don't think I am scaling things correctly.
// Position control is just plain wrong. This might also have to do with the Encoder returning a value
// between 0 and 1 that the value I am passing is 0 to 360.

  @Override public void periodic() {
    double Magnitude = currentVelocity.speedMetersPerSecond;
    double Direction = currentVelocity.angle.getDegrees();

    Drive.setControl( m_VelocityVoltage.withVelocity( Magnitude ) );
    Steer.setControl( m_PositionVoltage.withPosition( Direction ) );

  }

  private SwerveModulePosition currentPosition = new SwerveModulePosition ();
  private SwerveModuleState    currentVelocity = new SwerveModuleState    ();

  public SwerveModulePosition  getPosition () { return currentPosition; }
  public SwerveModuleState     getVelocity () { return currentVelocity; }

  public void setTargetState( SwerveModuleState targetState ) {
    currentVelocity = SwerveModuleState.optimize( targetState, currentVelocity.angle );

    currentPosition = new SwerveModulePosition(
      currentPosition.distanceMeters + ( currentVelocity.speedMetersPerSecond * 0.02 ),
      currentVelocity.angle
    );
  }

}
