package frc.robot.Subsystems;

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

    public double
      DirSP = 0, DirPV = 0, DirEr = 0, DirPw = 0,
      VelSP = 0, VelPV = 0, VelEr = 0, VelPw = 0;

// ================ SET POINTS ==================

  public SwerveModulePosition currentPosition = new SwerveModulePosition ();
  public SwerveModuleState    currentVelocity = new SwerveModuleState    ();

  public SwerveModulePosition  getPosition () { return currentPosition; }
  public SwerveModuleState     getVelocity () { return currentVelocity; }

// ================ TALONFX SETTING =============

    public VelocityVoltage m_VelocityVoltage = new VelocityVoltage( 0, 0, false, 0, 0, false, false, false ); // Slot 0
    // public PositionVoltage m_PositionVoltage = new PositionVoltage( 0, 0, false, 0, 1, false, false, false ); // Slot 1

// ================ SWERVE MODULE ===============

public SubSwerve( String name, int[] ID ) {
      Name  = name;
      Drive = new TalonFX ( ID[0] );
      Steer = new TalonFX ( ID[1] );
      Encod = new CANcoder( ID[2] );
    }

  @Override public void periodic() {

    // VELOCITY INFO
    VelPV = Drive.getVelocity().getValueAsDouble();
    VelSP = currentVelocity.speedMetersPerSecond * 100;
    VelEr = ( VelPV - VelSP );

    VelPw += VelEr * -0.001;

    if ( VelSP == 0 ) { VelPw = 0; }

    if ( Name == "FL" ) {
      SmartDashboard.putNumber( "VelPV", VelPV );
      SmartDashboard.putNumber( "VelSP", VelSP );
      SmartDashboard.putNumber( "VelEr", VelEr );
      SmartDashboard.putNumber( "VelPw", VelPw );

      SmartDashboard.putNumber( "Pos", Drive.getPosition().getValueAsDouble() );
    }

    // DIRECTION INFO
    DirPV = Encod.getAbsolutePosition().getValueAsDouble() * 360;
    DirSP = currentVelocity.angle.getDegrees();
    DirEr = ( DirPV - DirSP + 540 ) % 360 - 180;
    DirPw = DirEr * 0.01;

    Drive.set( VelPw );
    // Drive.setControl( m_VelocityVoltage.withVelocity( VelSP ) );
    Steer.set( DirPw );
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
