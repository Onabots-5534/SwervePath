package frc.robot.board;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class NavigationTab {

    public static ShuffleboardTab
        SBT;

    GenericEntry
        compass = null;

    public NavigationTab() {
        SBT = Shuffleboard.getTab("Navigation");

    }

}
