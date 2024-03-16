package frc.robot.Support;

// import java.util.List;

import com.pathplanner.lib.auto.AutoBuilder;
// import com.pathplanner.lib.path.GoalEndState;
import com.pathplanner.lib.path.PathConstraints;
// import com.pathplanner.lib.path.PathPlannerPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
// import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.Commands;
// import frc.robot.RobotContainer;

public class NewPose {

    public static Command Absolute( double X, double Y, double A ) {
        return AutoBuilder.pathfindToPose(
            new Pose2d( X, Y, Rotation2d.fromDegrees( A ) ), 
            new PathConstraints( 4.00, 4.00, Units.degreesToRadians( 360 ), Units.degreesToRadians( 540 ) ), 
            0.00, 0.00
        );
    }

    // public static void Relative( double X, double Y, double A ) {
    //     // Add a button to SmartDashboard that will create and follow an on-the-fly path
    //     // This example will simply move the robot 2m in the +X field direction
    //     SmartDashboard.putData( "On-the-fly path", Commands.runOnce( () -> {
    //     Pose2d currentPose = RobotContainer.m_Swerve.getPose();
        
    //     // The rotation component in these poses represents the direction of travel
    //     Pose2d startPos = new Pose2d( currentPose.getTranslation(), new Rotation2d() );
    //     Pose2d endPos   = new Pose2d( currentPose.getTranslation().plus( new Translation2d (2.00, 0.00 ) ), new Rotation2d() );

    //     List<Translation2d> bezierPoints = PathPlannerPath.bezierFromPoses( startPos, endPos );
    //     PathPlannerPath path = new PathPlannerPath(
    //         bezierPoints, 
    //         new PathConstraints( 4.00, 4.00, Units.degreesToRadians( 360 ), Units.degreesToRadians( 540 ) ),
    //         new GoalEndState( 0.0, currentPose.getRotation() )
    //     );

    //     // Prevent this path from being flipped on the red alliance, since the given positions are already correct
    //     path.preventFlipping = true;

    //     AutoBuilder.followPath( path ).schedule();
    //     }));
    // }

}
