package frc.robot.board;

import com.pathplanner.lib.commands.PathPlannerAuto;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class SBT_Test {

    public static ShuffleboardTab
        SBT = Shuffleboard.getTab("Test");

    // public static GenericEntry
    //     Distance = SBT.add( "TEST",0 ).getEntry();

    public static void Initialize() {

        // AUTON COMMANDS
        SBT.add( "Calibration", new PathPlannerAuto( "Calibration" ) );
    }

    public static void Periodic() {
        // Distance.setDouble( -1 );
    } 

}
