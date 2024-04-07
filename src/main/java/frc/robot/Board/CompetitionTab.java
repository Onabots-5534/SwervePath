package frc.robot.Board;

import java.util.Map;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Ssupport.*;

public class CompetitionTab {

    public ShuffleboardTab
        SBT;

    public static GenericEntry
        IntakeX,
        IntakeY,
        
        RobotX,
        RobotY,

        TargetX,
        TargetY;

    public CompetitionTab() {
        SBT = Shuffleboard.getTab("Competition");

        IntakeX = SBT.add("Intake X",0).withPosition( 0, 5 ).withSize( 2, 1 ).getEntry();
        IntakeY = SBT.add("Intake Y",0).withPosition( 3, 5 ).withSize( 2, 1 ).getEntry();

        RobotX  = SBT.add("Robot X",0).withPosition( 5, 0 ).withSize( 2, 1 ).getEntry();
        RobotY  = SBT.add("Robot Y",0).withPosition( 5, 1 ).withSize( 2, 1 ).getEntry();

        TargetX = SBT.add("Target X",0).withPosition( 11, 5 ).withSize( 2, 1 ).getEntry();
        TargetY = SBT.add("Target Y",0).withPosition( 14, 5 ).withSize( 2, 1 ).getEntry();

        // NAVIGATION
        SBT.add( Navigation.NavX )
        .withPosition( 5, 4 )
        .withSize( 3, 3 )
        .withWidget( BuiltInWidgets.kGyro );

        // INTAKE CAMERA
        SBT.addCamera( "Intake Camera", "Limelight 3", "http://10.55.34.13:5800" )
        .withPosition( 0, 0 )
        .withProperties( Map.of( "showControls", false ) )
        .withSize( 5, 5 )
        .withWidget( BuiltInWidgets.kCameraStream );

        // TARGET CAMERA
        SBT.addCamera( "Target Camera", "Limelight 2", "http://10.55.34.12:5800" )
        .withPosition( 11, 0 )
        .withProperties( Map.of( "showControls", false ) )
        .withSize( 5, 5 )
        .withWidget( BuiltInWidgets.kCameraStream );
    }

    public static void Refresh() {
        IntakeX.setDouble( CameraIntake.TX() );
    }

}
