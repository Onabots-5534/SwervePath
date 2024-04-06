package frc.robot.board;

import java.util.Map;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class CameraTab {

    public ShuffleboardTab
        SBT;

    GenericEntry
        IntakeX,
        IntakeY,
        
        TargetX,
        TargetY;

    public CameraTab() {
        SBT = Shuffleboard.getTab("Camera");

        SBT.addCamera( "Intake Camera", "Limelight 3", "http://10.55.34.13:5800" )
            .withPosition( 0, 0 )
            .withProperties( Map.of( "showControls", false ) )
            .withSize( 5, 5 )
            .withWidget( BuiltInWidgets.kCameraStream );

        IntakeX = SBT.add("Intake X",0).withPosition( 0, 5 ).withSize( 2, 1 ).getEntry();
        IntakeY = SBT.add("Intake Y",0).withPosition( 3, 5 ).withSize( 2, 1 ).getEntry();

        SBT.addCamera( "Target Camera", "Limelight 2", "http://10.55.34.12:5800" )
            .withPosition( 11, 0 )
            .withProperties( Map.of( "showControls", false ) )
            .withSize( 5, 5 )
            .withWidget( BuiltInWidgets.kCameraStream );

        TargetX = SBT.add("Target X",0).withPosition( 11, 5 ).withSize( 2, 1 ).getEntry();
        TargetY = SBT.add("Target Y",0).withPosition( 14, 5 ).withSize( 2, 1 ).getEntry();
    }

    public void setIntake( double X, double Y ) {
        IntakeX.setDouble( X );
        IntakeY.setDouble( Y );
    }

    public void setTarget( double X, double Y ) {
        TargetX.setDouble( X );
        TargetY.setDouble( Y );
    }

}
