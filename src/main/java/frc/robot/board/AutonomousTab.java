package frc.robot.board;

// import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class AutonomousTab {

    public ShuffleboardTab
        SBT;

    // GenericEntry
    //     ;

    public AutonomousTab() {
        SBT = Shuffleboard.getTab("Autonomous");

    }

}
