package frc.robot.Subsystems;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.util.PathPlannerLogging;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
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
import frc.robot.Sensor.Selector;

public class SubDrive extends SubsystemBase {
  private SimSwerveModule[]     modules;
  private SwerveDriveKinematics kinematics;
  private SwerveDriveOdometry   Odometer;

  private SimGyro
    gyro;
  
  private Field2d
    Field = new Field2d();
  
  public SubDrive() {
    gyro = new SimGyro();

    modules = new SimSwerveModule[]{
      new SimSwerveModule(),
      new SimSwerveModule(),
      new SimSwerveModule(),
      new SimSwerveModule()
    };

    kinematics = new SwerveDriveKinematics(
      Constants.Swerve.FL_Trans2d, 
      Constants.Swerve.FR_Trans2d, 
      Constants.Swerve.BL_Trans2d, 
      Constants.Swerve.BR_Trans2d
    );

    Odometer = new SwerveDriveOdometry(
      kinematics,
      gyro.getRotation2d(),
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
    // Update the simulated gyro, not needed in a real project
    gyro.updateRotation( getSpeeds().omegaRadiansPerSecond );
    Odometer .update( gyro.getRotation2d(), getPositions() );
    Field    .setRobotPose( getPose() );
  }

  public Pose2d getPose() {
    return Odometer.getPoseMeters();
  }

  public void resetPose( Pose2d pose ) {
    Odometer.resetPosition( gyro.getRotation2d(), getPositions(), pose );
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
    setStates( targetStates );
  }

  public void setStates(SwerveModuleState[] targetStates) {
    SwerveDriveKinematics.desaturateWheelSpeeds( targetStates, Constants.Swerve.maxModuleSpeed );
    for (int i = 0; i < modules.length; i++) { modules[i].setTargetState( targetStates[i] ); }
  }

  public SwerveModuleState[] getModuleStates() {
    SwerveModuleState[] states = new SwerveModuleState[modules.length];
    for ( int i = 0; i < modules.length; i++ ) { states[i] = modules[i].getState(); }
    return states;
  }

  public SwerveModulePosition[] getPositions() {
    SwerveModulePosition[] positions = new SwerveModulePosition[ modules.length ];
    for ( int i = 0; i < modules.length; i++ ) { positions[i] = modules[i].getPosition(); }
    return positions;
  }

  /**
   * Basic simulation of a swerve module, will just hold its current state and not use any hardware
   */
  class SimSwerveModule {
    private SwerveModulePosition currentPosition = new SwerveModulePosition ();
    private SwerveModuleState    currentState    = new SwerveModuleState    ();

    public SwerveModulePosition getPosition () { return currentPosition; }
    public SwerveModuleState    getState    () { return currentState;    }

    public void setTargetState(SwerveModuleState targetState) {
      // Optimize the state
      currentState = SwerveModuleState.optimize(
        targetState,
        currentState.angle
      );

      currentPosition = new SwerveModulePosition(
        currentPosition.distanceMeters + ( currentState.speedMetersPerSecond * 0.02 ),
        currentState.angle
      );
    }
  }

  /**
   * Basic simulation of a gyro, will just hold its current state and not use any hardware
   */
  class SimGyro {
    private Rotation2d currentRotation = new Rotation2d();

    public Rotation2d getRotation2d() {
      return currentRotation;
    }

    public void updateRotation( double angularVelRps ) {
      currentRotation = currentRotation.plus( new Rotation2d( angularVelRps * 0.02 ) );
    }
  }
}
