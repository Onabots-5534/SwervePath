package frc.robot.Subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
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

    public SubSwerve( int[] ID ) {
      Drive = new TalonFX ( ID[0] );
      Steer = new TalonFX ( ID[1] );
      Encod = new CANcoder( ID[2] );

      final PositionVoltage m_voltagePosition = new PositionVoltage( 0, 0, true, 0, 0, false, false, false ); // Slot0
      final VelocityVoltage m_voltageVelocity = new VelocityVoltage( 0, 0, true, 0, 1, false, false, false ); // Slot1

      TalonFXConfiguration configs = new TalonFXConfiguration();
      
      /* VOLTAGE BASED VELOCITY */
      configs.Slot0.kP = 0.10; // An error of 1 rev/sec => 2V output
      configs.Slot0.kI = 0.00; //
      configs.Slot0.kD = 0.00; //
      configs.Slot0.kV = 0.12; //

      /* POSITION CONTROL */
      configs.Slot1.kP = 0.10; //
      configs.Slot1.kI = 0.00; //
      configs.Slot1.kD = 0.00; //
      configs.Slot1.kV = 0.05; //

      configs.CurrentLimits.StatorCurrentLimit       = 40;
      configs.CurrentLimits.StatorCurrentLimitEnable = true;

      configs.Voltage.PeakForwardVoltage =  8;
      configs.Voltage.PeakReverseVoltage = -8;

      // configs.TorqueCurrent.PeakForwardTorqueCurrent =  40;
      // configs.TorqueCurrent.PeakReverseTorqueCurrent = -40;

      Drive.getConfigurator().apply( configs );
      Steer.getConfigurator().apply( configs );
    }

  @Override public void periodic() {
    // Drive.setControl( null );
    // Steer.setControl( null );
  }

  private SwerveModulePosition currentPosition = new SwerveModulePosition ();
  private SwerveModuleState    currentState    = new SwerveModuleState    ();

  public SwerveModulePosition getPosition () { return currentPosition; }
  public SwerveModuleState    getState    () { return currentState;    }

  public void setTargetState( SwerveModuleState targetState ) {
    currentState = SwerveModuleState.optimize( targetState, currentState.angle );
    currentPosition = new SwerveModulePosition(
      currentPosition.distanceMeters + ( currentState.speedMetersPerSecond * 0.02 ),
      currentState.angle
    );
  }

}
