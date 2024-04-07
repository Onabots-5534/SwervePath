package frc.robot.board;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.subsystems.SubDrive;
import frc.robot.support.Board;

public class DrivetrainTab {

    public ShuffleboardTab
        SBT;

    public static GenericEntry
        FL_PV,
        FL_SP;

    public DrivetrainTab() {
        SBT = Board.SBT_Drivetrain; // Shuffleboard.getTab("Drivetrain");

        FL_PV = SBT.add("FL PV",0).getEntry();
        FL_SP = SBT.add("FL SP",0).getEntry();
    }

    public static void Refresh() {
        FL_PV.setDouble( SubDrive.Modules[0].VelPV );
        FL_SP.setDouble( SubDrive.Modules[0].VelSP );
    }

}
