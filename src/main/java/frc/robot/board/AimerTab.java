package frc.robot.board;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class AimerTab {

    public ShuffleboardTab
        SBT;

    GenericEntry
        state = null;

    public AimerTab() {
        SBT = Shuffleboard.getTab("Aimer");

        state = SBT.add( "Power", true ).getEntry();
    }

}
