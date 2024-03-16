package frc.robot.Config;

import com.pathplanner.lib.util.HolonomicPathFollowerConfig;
import com.pathplanner.lib.util.PIDConstants;
import com.pathplanner.lib.util.ReplanningConfig;

import edu.wpi.first.math.geometry.Translation2d;

public final class Constants {
  
  public static double
    RobotLength = 35,
    RobotWidth  = 35;

  public static final class Swerve {
    public static final double
      maxModuleSpeed = 4.5; // M/S

    public static final Translation2d
      flModuleOffset = new Translation2d(  RobotLength/2,  RobotWidth/2 ),
      frModuleOffset = new Translation2d(  RobotLength/2, -RobotWidth/2 ),
      blModuleOffset = new Translation2d( -RobotLength/2,  RobotWidth/2 ),
      brModuleOffset = new Translation2d( -RobotLength/2, -RobotWidth/2 );

    public static final HolonomicPathFollowerConfig
      pathFollowerConfig = new HolonomicPathFollowerConfig(
        new PIDConstants( 5.0, 0, 0 ), // Translation constants 
        new PIDConstants( 5.0, 0, 0 ), // Rotation constants 
        maxModuleSpeed,                // Maximum module speed
        flModuleOffset.getNorm(),      // Drive base radius (distance from center to furthest module) 
        new ReplanningConfig()
      );
  }
}
