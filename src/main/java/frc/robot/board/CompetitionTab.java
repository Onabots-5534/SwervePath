package frc.robot.board;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class CompetitionTab {

    public ShuffleboardTab
        SBT;

    GenericEntry
        RobotX = null,
        RobotY = null,
        RobotT = null;

    public CompetitionTab() {
        SBT = Shuffleboard.getTab("Competition");

        RobotX = SBT.add("Robot X",0).getEntry();
        RobotY = SBT.add("Robot Y",0).getEntry();
        RobotT = SBT.add("Robot T",0).getEntry();
    }

    public void setRobotX( double X ) { RobotX.setDouble(X); }
    public void setRobotY( double Y ) { RobotX.setDouble(Y); }
    public void setRobotZ( double Z ) { RobotX.setDouble(Z); }

}
