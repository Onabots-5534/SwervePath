package frc.robot.board;

// import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class CompetitionTab {

    public ShuffleboardTab
        SBT;

    // GenericEntry
    //     ;

    public CompetitionTab() {
        SBT = Shuffleboard.getTab("Competition");

    }

}
