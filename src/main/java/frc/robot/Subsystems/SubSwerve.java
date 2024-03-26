package frc.robot.Subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;

import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Config.Constants;

public class SubSwerve extends SubsystemBase {

    public String
      Name;

    public TalonFX
      Drive,
      Steer;

    public CANcoder
      Encod;

    public double
      DirSP = 0,
      DirPV = 0;

    public PositionVoltage m_VoltagePosition = new PositionVoltage( 0, 0, false, 0, 0, false, false, false ); // Slot0
    public VelocityVoltage m_VoltageVelocity = new VelocityVoltage( 0, 0, false, 0, 1, false, false, false ); // Slot1

    public SubSwerve( String name, int[] ID ) {
      Name  = name;
      Drive = new TalonFX ( ID[0] );
      Steer = new TalonFX ( ID[1] );
      Encod = new CANcoder( ID[2] );

      // TalonFXConfiguration configs = new TalonFXConfiguration();
      
      // /* POSITION CONTROL */
      // configs.Slot0.kP = 0.10; // 
      // configs.Slot0.kI = 0.00; //
      // configs.Slot0.kD = 0.00; //
      // configs.Slot0.kV = 0.01; //

      // /* VELOCITY CONTROL */
      // configs.Slot1.kP = 0.10; // An error of 1 rev/sec => 2V output
      // configs.Slot1.kI = 0.00; //
      // configs.Slot1.kD = 0.00; //
      // configs.Slot1.kV = 0.12; //

      // // CONFIGURE TO USE EXTERNAL SENSOR
      // configs.Feedback.FeedbackSensorSource   = FeedbackSensorSourceValue.RemoteCANcoder;
      // configs.Feedback.FeedbackRemoteSensorID = ID[2];

      // configs.CurrentLimits.StatorCurrentLimit       = 40;
      // configs.CurrentLimits.StatorCurrentLimitEnable = true;

      // configs.Voltage.PeakForwardVoltage =  8;
      // configs.Voltage.PeakReverseVoltage = -8;

      // configs.TorqueCurrent.PeakForwardTorqueCurrent =  40;
      // configs.TorqueCurrent.PeakReverseTorqueCurrent = -40;


      // Drive.getConfigurator().apply( configs );
      // Steer.getConfigurator().apply( configs );
    }

  @Override public void periodic() {
    double Magnitude = currentVelocity.speedMetersPerSecond;
    double Direction = currentVelocity.angle.getDegrees();

    Drive.setControl( m_VoltageVelocity.withVelocity( Magnitude * Constants.Swerve.maxModuleSpeed ) );
    Steer.setControl( m_VoltagePosition.withPosition( Direction ) );
  }

  public SwerveModulePosition currentPosition = new SwerveModulePosition ();
  public SwerveModuleState    currentVelocity = new SwerveModuleState    ();

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
