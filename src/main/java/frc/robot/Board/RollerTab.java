package frc.robot.board;

// import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class RollerTab {

    public ShuffleboardTab
        SBT;

    // GenericEntry
    //     ;

    public RollerTab() {
        SBT = Shuffleboard.getTab("Roller");

    }

}
