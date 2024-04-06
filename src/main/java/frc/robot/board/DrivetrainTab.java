package frc.robot.board;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class DrivetrainTab {

    public ShuffleboardTab
        SBT;

    GenericEntry
        RobotX,
        RobotY,
        RobotT;

    public DrivetrainTab() {
        SBT = Shuffleboard.getTab("Drivetrain");

        // ROBOT COORDINATES
        RobotX = SBT.add("RobotX",0).getEntry();
    }

    public void SetCoord() {
        
    }

}
