package frc.robot.board;

import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.subsystems.SubDrive;

public class SBT_Test {

    public static ShuffleboardTab
        SBT = Shuffleboard.getTab("Test");

    public static GenericEntry
        FL_Clicks = SBT.add( "FL Clicks",0 ).getEntry();

    public static void Initialize() {

        // AUTON COMMANDS
        SBT.add( "Calibration", new PathPlannerAuto( "Calibration" ) )
        .withPosition( 5, 0 ).withSize( 2, 2 );
    }

    public static void Periodic() {
        FL_Clicks.setDouble( SubDrive.Modules[0].Drive.getPosition().getValueAsDouble() );
    } 

}
