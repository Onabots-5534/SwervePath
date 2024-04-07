package frc.robot.board;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class DrivetrainTab {

    public ShuffleboardTab
        SBT;

    public static GenericEntry
        FP_PV,
        FL_SP;

    public DrivetrainTab() {
        SBT = Shuffleboard.getTab("Drivetrain");

        FL_PV = SBT.add("FL PV",0).getEntry();
        FL_SP = SBT.add("FL SP",0).getEntry();
    }

    public void Refresh() {
        FL_PV.setDouble( RobotContainer.m_Drive.Modules[0],VelPV );
        FL_SP.setDouble( RobotContainer.m_Drive.Modules[0].VelSP );
    }

}
