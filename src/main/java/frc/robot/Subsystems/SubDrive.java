package frc.robot.Subsystems;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.util.PathPlannerLogging;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Config.Constants;
import frc.robot.Config.Ports.pSwerve;
import frc.robot.Sensor.Navigation;
import frc.robot.Sensor.Selector;

public class SubDrive extends SubsystemBase {
  public SubSwerve[]           modules;
  public SwerveDriveKinematics kinematics;
  public SwerveDriveOdometry   Odometer;

  private Field2d
    field = new Field2d();

// Drive Ratio is ... ?
// Steer Ratio is 8.14 : 1

  public static double
    kWheelDiameterInches  = 4.00, // 4 inch diameter wheel
    kGearRatio            = 14,   // TODO: get this from Bryan, this is for the Drive Wheel
    kCountsPerRev         = 2048, // from encoder
    k100msPerSecond       = 10,   // just a constant, 100
    kWheelCircumference   = Math.PI * Units.inchesToMeters( kWheelDiameterInches );

  public SubDrive() {

    modules = new SubSwerve[]{
      new SubSwerve( "FL", pSwerve.CAN_FL ),
      new SubSwerve( "FR", pSwerve.CAN_FR ),
      new SubSwerve( "BL", pSwerve.CAN_BL ),
      new SubSwerve( "BR", pSwerve.CAN_BR )
    };

    kinematics = new SwerveDriveKinematics(
      Constants.Swerve.FL_Trans2d, 
      Constants.Swerve.FR_Trans2d, 
      Constants.Swerve.BL_Trans2d, 
      Constants.Swerve.BR_Trans2d
    );

    Odometer = new SwerveDriveOdometry(
      kinematics,
      Navigation.NavX.getRotation2d(),
      getPositions()
    );

    AutoBuilder.configureHolonomic(
      this::getPose, 
      this::resetPose, 
      this::getSpeeds, 
      this::DriveRobotRelative, 
      Constants.Swerve.pathFollowerConfig,
      () -> { return Selector.isRed(); }, // Boolean supplier indicating when to flip path for Red
      this
    );

    // Set up custom logging to add the current path to a field 2d widget
    PathPlannerLogging.setLogActivePathCallback( ( poses ) -> field.getObject( "path" ).setPoses( poses ) );
    SmartDashboard.putData( "Field", field );
  }

  @Override public void periodic() {
    Odometer.update( Navigation.NavX.getRotation2d(), getPositions());
    field.setRobotPose( getPose() );
  }

//
// POSE INFORMATION
//
  public Pose2d getPose() {
    return Odometer.getPoseMeters();
  }

  public void resetPose( Pose2d pose ) {
    Odometer.resetPosition( Navigation.NavX.getRotation2d(), getPositions(), pose );
  }

//
// FIELD AND ROBOT RELATIVE CALLS
//
  public void DriveFieldRelative( ChassisSpeeds FieldSpeeds ) {
    DriveRobotRelative( ChassisSpeeds.fromFieldRelativeSpeeds( FieldSpeeds, getPose().getRotation() ) );
  }

  public void DriveRobotRelative( ChassisSpeeds RobotSpeeds ) {
    ChassisSpeeds       targetSpeeds = ChassisSpeeds.discretize( RobotSpeeds, 0.02 );
    SwerveModuleState[] targetStates = kinematics.toSwerveModuleStates( targetSpeeds );
    SetStates( targetStates );
  }

  public void SetStates( SwerveModuleState[] targetStates ) {
    SwerveDriveKinematics.desaturateWheelSpeeds( targetStates, Constants.Swerve.maxModuleSpeed );
    for (int i = 0; i < modules.length; i++) { modules[i].SetTargetState( targetStates[i] ); }
  }

//
// SUPPORT FUNCTIONS
//
  public ChassisSpeeds getSpeeds() {
    return kinematics.toChassisSpeeds( getModuleStates() );
  }

  public SwerveModulePosition[] getPositions() {
    SwerveModulePosition[] positions = new SwerveModulePosition[ modules.length ];
    for ( int i = 0; i < modules.length; i++ ) { positions[i] = modules[i].GetPosition(); }
    return positions;
  }

  public SwerveModuleState[] getModuleStates() {
    SwerveModuleState[] states = new SwerveModuleState[modules.length];
    for ( int i = 0; i < modules.length; i++ ) { states[i] = modules[i].GetVelocity(); }
    return states;
  }

//
//  DISTANCE CALCULATIONS
//
  public int DistanceToNativeUnits( double PositionMeters ) {
    double WheelRotations = PositionMeters / kWheelCircumference;
    double MotorRotations = WheelRotations * kGearRatio;
    int    SensorCounts   = (int)( MotorRotations * kCountsPerRev );
    return SensorCounts;
}

  public int VelocityToNativeUnits( double VelocityMetersPerSecond ) {
      double WheelRotationsPerSecond = VelocityMetersPerSecond / kWheelCircumference;
      double MotorRotationsPerSecond = WheelRotationsPerSecond * kGearRatio;
      double MotorRotationsPer100ms  = MotorRotationsPerSecond / k100msPerSecond;
      int    SensorCountsPer100ms    = (int)( MotorRotationsPer100ms * kCountsPerRev );
      return SensorCountsPer100ms;
  }

  public double NativeUnitsToDistanceMeters( double SensorCounts ) {
      double MotorRotations = (double)SensorCounts / kCountsPerRev;
      double WheelRotations = MotorRotations / kGearRatio;
      double PositionMeters = WheelRotations * kWheelCircumference;
      return PositionMeters;
  }

}
