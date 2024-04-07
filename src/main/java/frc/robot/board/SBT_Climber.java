package frc.robot.board;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.subsystems.SubClimber;

public class SBT_Climber {

    public static ShuffleboardTab
        SBT = Shuffleboard.getTab("Climber");

    public static GenericEntry
        Distance = SBT.add( "Distance" ,0 ).getEntry(),
        Power    = SBT.add( "Power"    ,0 ).getEntry();

    public static void Initialize() {}

    public static void Periodic() {
        Distance.setDouble( -1 );
        Power   .setDouble( SubClimber.Power );
    } 

}
