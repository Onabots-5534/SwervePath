package frc.robot.board;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class MoverTab {

    public ShuffleboardTab
        SBT;

    GenericEntry
        power;

    public MoverTab() {
        SBT = Shuffleboard.getTab("Mover");

    }

}
