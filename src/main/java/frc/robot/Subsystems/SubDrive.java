package frc.robot.Subsystems;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.util.PathPlannerLogging;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Config.Constants;
import frc.robot.Config.Ports.pSwerve;
import frc.robot.Sensor.Navigation;
import frc.robot.Sensor.Selector;

public class SubDrive extends SubsystemBase {
  public SubSwerve[]           Modules                    ;
  public SwerveDriveKinematics kinematics                 ;
  public SwerveDriveOdometry   Odometer                   ;
  public Field2d               Field      = new Field2d() ;
  
  public SubDrive() {

    Modules = new SubSwerve[]{
      new SubSwerve( pSwerve.CAN_FL ),
      new SubSwerve( pSwerve.CAN_FR ),
      new SubSwerve( pSwerve.CAN_BL ),
      new SubSwerve( pSwerve.CAN_BR )
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
      this::driveRobotRelative, 
      Constants.Swerve.pathFollowerConfig,
      () -> { return Selector.isRed(); }, // Boolean supplier indicating when to flip path for Red
      this
    );

    // Set up custom logging to add the current path to a field 2d widget
    PathPlannerLogging.setLogActivePathCallback( ( poses ) -> Field.getObject( "path" ).setPoses( poses ) );
    SmartDashboard.putData( "Field", Field );
  }

  @Override public void periodic() {
    Odometer .update( Navigation.NavX.getRotation2d(), getPositions() );
    Field    .setRobotPose( getPose() );
  }

  public Pose2d getPose() {
    return Odometer.getPoseMeters();
  }

  public void resetPose( Pose2d pose ) {
    Odometer.resetPosition( Navigation.NavX.getRotation2d(), getPositions(), pose );
  }

  public ChassisSpeeds getSpeeds() {
    return kinematics.toChassisSpeeds( getModuleStates() );
  }

//
// CALLABLE FUNCTIONS
//
  public void     FieldDrive( double X, double Y, double Z ) { driveFieldRelative( new ChassisSpeeds( X, Y, Z ) ); }
  public Command cFieldDrive( double X, double Y, double Z ) { return this.runOnce( () -> FieldDrive( X, Y, Z ) ); }

  public void     RobotDrive( double X, double Y, double Z ) { driveRobotRelative( new ChassisSpeeds( X, Y, Z ) ); }
  public Command cRobotDrive( double X, double Y, double Z ) { return this.runOnce( () -> RobotDrive( X, Y, Z ) ); }


  public void driveFieldRelative( ChassisSpeeds FieldSpeeds ) {
    driveRobotRelative( ChassisSpeeds.fromFieldRelativeSpeeds( FieldSpeeds, getPose().getRotation() ) );
  }

  public void driveRobotRelative( ChassisSpeeds RobotSpeeds ) {
    ChassisSpeeds       targetSpeeds = ChassisSpeeds.discretize( RobotSpeeds, 0.02 );
    SwerveModuleState[] targetStates = kinematics.toSwerveModuleStates( targetSpeeds );

    // setStates( targetStates );
    SwerveDriveKinematics.desaturateWheelSpeeds( targetStates, Constants.Swerve.maxModuleSpeed );
    for ( int i = 0; i < Modules.length; i++ ) { Modules[i].setTargetState( targetStates[i] ); }
  }

  // public void setStates( SwerveModuleState[] targetStates ) {
  //   SwerveDriveKinematics.desaturateWheelSpeeds( targetStates, Constants.Swerve.maxModuleSpeed );
  //   for ( int i = 0; i < Modules.length; i++ ) { Modules[i].setTargetState( targetStates[i] ); }
  // }

  public SwerveModuleState[] getModuleStates() {
    SwerveModuleState[] states = new SwerveModuleState[ Modules.length];
    for ( int i = 0; i < Modules.length; i++ ) { states[i] = Modules[i].getVelocity(); }
    return states;
  }

  public SwerveModulePosition[] getPositions() {
    SwerveModulePosition[] positions = new SwerveModulePosition[ Modules.length ];
    for ( int i = 0; i < Modules.length; i++ ) { positions[i] = Modules[i].getPosition(); }
    return positions;
  }

}
