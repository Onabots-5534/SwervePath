package frc.robot.Config;

import com.pathplanner.lib.util.HolonomicPathFollowerConfig;
// import com.pathplanner.lib.util.PIDConstants;
import com.pathplanner.lib.util.ReplanningConfig;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;

public final class Constants {

// ================ SWERVE DRIVE ================

  public static double
    RobotLength = Units.inchesToMeters( 35 ),
    RobotWidth  = Units.inchesToMeters( 35 );

  public static final class Swerve {
    public static final double
      maxModuleSpeed = 4.5; // M/S

    public static final Translation2d
      FL_Trans2d = new Translation2d(  RobotLength/2,  RobotWidth/2 ),
      FR_Trans2d = new Translation2d(  RobotLength/2, -RobotWidth/2 ),
      BL_Trans2d = new Translation2d( -RobotLength/2,  RobotWidth/2 ),
      BR_Trans2d = new Translation2d( -RobotLength/2, -RobotWidth/2 );

    public static final HolonomicPathFollowerConfig
      pathFollowerConfig = new HolonomicPathFollowerConfig(
        // new PIDConstants( 5.0, 0, 0 ), // Translation constants 
        // new PIDConstants( 5.0, 0, 0 ), // Rotation constants 
        maxModuleSpeed,                // Maximum module speed
        FL_Trans2d.getNorm(),          // Drive base radius (distance from center to furthest module) 
        new ReplanningConfig()
      );
  }

}

// TODO Implement Flipper features