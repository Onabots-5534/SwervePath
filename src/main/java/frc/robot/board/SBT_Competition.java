package frc.robot.board;

import java.util.Map;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SubDrive;
import frc.robot.support.*;

public class SBT_Competition {

    public static ShuffleboardTab
        SBT = Shuffleboard.getTab("Competition");

    public static GenericEntry
        IntakeX = SBT.add("Intake X",0).withPosition(  0, 5 ).withSize( 2, 1 ).getEntry(),
        IntakeY = SBT.add("Intake Y",0).withPosition(  3, 5 ).withSize( 2, 1 ).getEntry(),

        RobotX  = SBT.add("Robot X", 0).withPosition(  5, 0 ).withSize( 2, 1 ).getEntry(),
        RobotY  = SBT.add("Robot Y", 0).withPosition(  5, 1 ).withSize( 2, 1 ).getEntry(),

        TargetX = SBT.add("Target X",0).withPosition( 11, 5 ).withSize( 2, 1 ).getEntry(),
        TargetY = SBT.add("Target Y",0).withPosition( 14, 5 ).withSize( 2, 1 ).getEntry();

    public static void Initialize() {

        // AUTON SELECTOR
        SBT.add( "Auton Selector", AutonSelector.m_Chooser )
        .withWidget( BuiltInWidgets.kComboBoxChooser )
        .withPosition( 7, 4 ).withSize( 2, 1 );

        // FIELD DIAGRAM
        SBT.add( "Field Diagram", SubDrive.Field )
        .withPosition( 5, 0 ).withSize( 6, 4 );

        // NAVIGATION
        SBT.add( Navigation.NavX )
        .withPosition( 5, 4 ).withSize( 3, 3 )
        .withWidget( BuiltInWidgets.kGyro );

        // INTAKE CAMERA
        SBT.addCamera( "Intake Camera", "Limelight 3", "http://10.55.34.13:5800" )
        .withPosition( 0, 0 ).withSize( 5, 5 )
        .withProperties( Map.of( "showControls", false ) )
        .withWidget( BuiltInWidgets.kCameraStream );

        // TARGET CAMERA
        SBT.addCamera( "Target Camera", "Limelight 2", "http://10.55.34.12:5800" )
        .withPosition( 11, 0 ).withSize( 5, 5 )
        .withProperties( Map.of( "showControls", false ) )
        .withWidget( BuiltInWidgets.kCameraStream );
    }

    public static void Periodic() {
        IntakeX.setDouble( CameraIntake.TX() );
        IntakeY.setDouble( CameraIntake.TY() );

        Pose2d Pose = RobotContainer.m_Drive.getPose();
        RobotX.setDouble( Pose.getX() );
        RobotY.setDouble( Pose.getY() );

        TargetX.setDouble( CameraTarget.TX() );
        TargetY.setDouble( CameraTarget.TY() );
    }

}
