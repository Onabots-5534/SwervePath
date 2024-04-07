package frc.robot.board;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.subsystems.SubDrive;

public class SBT_Drivetrain {

    public static ShuffleboardTab
        SBT = Shuffleboard.getTab("Drivetrain");

    public static GenericEntry
        FL_PV = SBT.add("FL PV",0).withPosition( 5, 0 ).withSize( 2, 1 ).getEntry(),
        FL_SP = SBT.add("FL SP",0).withPosition( 5, 0 ).withSize( 2, 1 ).getEntry();

        Auton_Scale = SBT.addPersistent("Auton Scale",0).withPosition( 7, 1 ).withSize( 2, 1 ).getEntry;

    public static void Initialize() {
    }
    
    public static void Periodic() {
        FL_PV.setDouble( SubDrive.Modules[0].VelPV );
        FL_SP.setDouble( SubDrive.Modules[0].VelSP );
    }

// ================ FUNCTIONS ===================

    // public static double GetAutonScale() { return Auton_Scale.}


}
