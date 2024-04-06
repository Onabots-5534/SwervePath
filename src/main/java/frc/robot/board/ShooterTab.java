package frc.robot.board;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class ShooterTab {

    public ShuffleboardTab
        SBT;

    GenericEntry
        power = null;

    public ShooterTab() {
        SBT = Shuffleboard.getTab("Shooter");

        power = SBT.add( "Power", 0 ).getEntry();
    }

}
