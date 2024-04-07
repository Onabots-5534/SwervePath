package frc.robot.Board;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Subsystems.SubClimber;

public class ClimberTab {

    public ShuffleboardTab
        SBT;

    public static GenericEntry
        Distance = null,
        Power    = null;

    public ClimberTab() {
        SBT = Shuffleboard.getTab("Climber");

        Distance = SBT.add( "Distance" ,0 ).getEntry();
        Power    = SBT.add( "Power"    ,0 ).getEntry();
    }

    public static void Refresh() {
        Distance.setDouble( -1 );
        Power   .setDouble( SubClimber.Power );
    } 

}
