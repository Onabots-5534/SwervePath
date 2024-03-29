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
  public SwerveDriveKinematics Kinematics                 ;
  public SwerveDriveOdometry   Odometer                   ;
  public Field2d               Field      = new Field2d() ;
  
  public SubDrive() {

    Modules = new SubSwerve[]{
      new SubSwerve( pSwerve.CAN_FL ),
      new SubSwerve( pSwerve.CAN_FR ),
      new SubSwerve( pSwerve.CAN_BL ),
      new SubSwerve( pSwerve.CAN_BR )
    };

    Kinematics = new SwerveDriveKinematics(
      Constants.Swerve.FL_Trans2d, 
      Constants.Swerve.FR_Trans2d, 
      Constants.Swerve.BL_Trans2d, 
      Constants.Swerve.BR_Trans2d
    );

    Odometer = new SwerveDriveOdometry(
      Kinematics,
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
    return Kinematics.toChassisSpeeds( getModuleStates() );
  }


// ================ DRIVE STICK =================


/* Driving the robot will eventuall call one of the following functons or commands. Passed
 * in are the velocity components of the motion. At some point, we need to apply a deadband
 * and other limiting factors. 
 */

  public void     FieldDrive( double X, double Y, double Z ) { driveFieldRelative( new ChassisSpeeds( X, Y, Z ) ); }
  public Command cFieldDrive( double X, double Y, double Z ) { return this.runOnce( () -> FieldDrive( X, Y, Z ) ); }

  public void     RobotDrive( double X, double Y, double Z ) { driveRobotRelative( new ChassisSpeeds( X, Y, Z ) ); }
  public Command cRobotDrive( double X, double Y, double Z ) { return this.runOnce( () -> RobotDrive( X, Y, Z ) ); }

// ================ SUPPORT FUNCTIONS ===========

  public void driveFieldRelative( ChassisSpeeds FieldSpeeds ) {
    driveRobotRelative( ChassisSpeeds.fromFieldRelativeSpeeds( FieldSpeeds, getPose().getRotation() ) );
  }

  // This method takes the ChassisSpeeds and sets each individual swerve modules to their respective values.
  // NOTE: This does NOT send the information to the motor controllers. It only sets the values in each modules
  // to the target value. The periodic() method will pick up these values and set the motor controllers.
  public void driveRobotRelative( ChassisSpeeds RobotSpeeds ) {
    ChassisSpeeds       targetSpeeds = ChassisSpeeds.discretize( RobotSpeeds, 0.02 );
    SwerveModuleState[] targetStates = Kinematics.toSwerveModuleStates( targetSpeeds );

    SwerveDriveKinematics.desaturateWheelSpeeds( targetStates, Constants.Swerve.maxModuleSpeed );
    for ( int i = 0; i < Modules.length; i++ ) { Modules[i].setTargetState( targetStates[i] ); }
  }

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
