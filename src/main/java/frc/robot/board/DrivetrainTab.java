package frc.robot.board;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class DrivetrainTab {

    public ShuffleboardTab
        SBT;

    public static GenericEntry
        RobotX,
        RobotY;

    public DrivetrainTab() {
        SBT = Shuffleboard.getTab("Drivetrain");

        RobotX = SBT.add("Robot X",0).withPosition( 5, 0 ).withSize( 2, 1 ).getEntry();
        RobotY = SBT.add("Robot Y",0).withPosition( 5, 1 ).withSize( 2, 1 ).getEntry();
    }

    public void Refresh() {
    }

}
