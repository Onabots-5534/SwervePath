package frc.robot.Subsystems;

import javax.xml.stream.events.EndDocument;

// import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
// import com.ctre.phoenix6.controls.VelocityDutyCycle;
// import com.ctre.phoenix6.controls.VelocityTorqueCurrentFOC;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SubSwerve extends SubsystemBase {

    public String
      Name;

    public TalonFX
      Drive,
      Steer;

    public CANcoder
      Encod;

// ================ SET POINTS ==================

  private SwerveModulePosition currentPosition = new SwerveModulePosition ();
  private SwerveModuleState    currentVelocity = new SwerveModuleState    ();

  public SwerveModulePosition  getPosition () { return currentPosition; }
  public SwerveModuleState     getVelocity () { return currentVelocity; }

// ================ TALONFX SETTING =============

    public VelocityVoltage m_VelocityVoltage = new VelocityVoltage( 0, 0, false, 0, 0, false, false, false ); // Slot 0
    public PositionVoltage m_PositionVoltage = new PositionVoltage( 0, 0, false, 0, 1, false, false, false ); // Slot 1

// ================ SWERVE MODULE ===============

public SubSwerve( String name, int[] ID ) {
      Name  = name;
      Drive = new TalonFX ( ID[0] );
      Steer = new TalonFX ( ID[1] );
      Encod = new CANcoder( ID[2] );

// This code was dropped in favor of configuring that TalonFX with Phoenix Tuner X. I may go back to setting
// this programatically once the Position and Velocity configs are separated out.

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
// between 0 and 1 that the value I am passing is 0 to 360. Also, the PID controller might incorrect.

  @Override public void periodic() {
    double Magnitude = currentVelocity.speedMetersPerSecond;
    double Direction = currentVelocity.angle.getDegrees();

    // At this point, I should take over the handling and translate into values that I understand. First though,
    // display what is currently being presented so that I may collect data and make a good decision.

    if ( Name == "BL" ) {
      SmartDashboard.putNumber( "Vel-SP", Magnitude );
      SmartDashboard.putNumber( "Dir-SP", Direction );

      SmartDashboard.putNumber( "Vel-PV", Drive.getVelocity()        .getValueAsDouble() );
      SmartDashboard.putNumber( "Dir-PV", Encod.getAbsolutePosition().getValueAsDouble() );
    }

    Drive.setControl( m_VelocityVoltage.withVelocity( Magnitude ) );
    Steer.setControl( m_PositionVoltage.withPosition( Direction ) );

  }

  public void setTargetState( SwerveModuleState targetState ) {
    currentVelocity = SwerveModuleState.optimize( targetState, currentVelocity.angle );

    currentPosition = new SwerveModulePosition(
      currentPosition.distanceMeters + ( currentVelocity.speedMetersPerSecond * 0.02 ),
      currentVelocity.angle
    );
  }

// CANCODER
// CANCoder cancoder = new CANcoder( ... )
// CANcoderConfiguration = cfg = new CAN ...
// configs.MangetSensor.AbsoluteSensorRange = AbsoluteSensorRange.Signed_PlusMinusHalf
//   MountPose.MagnetOffset = 0.26;
//   MountPose.SensorDirection = SensorDirectionValue.Clockwise_Positive
// cancoder.getConfigurator().apply( configs )
// cancoder.setPosition( 0 );

  
}
