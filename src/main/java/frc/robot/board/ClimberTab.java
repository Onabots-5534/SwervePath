package frc.robot.board;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class ClimberTab {

    public ShuffleboardTab
        SBT;

    GenericEntry
        distance = null,
        power    = null;

    public ClimberTab() {
        SBT = Shuffleboard.getTab("Climber");

        distance = SBT.add( "Distance" ,0 ).getEntry();
        power    = SBT.add( "Power"    ,0 ).getEntry();
    }

    public double getDistance() { return distance.getDouble( 0 ); }
    public void setDistance( double D ) { distance.setDouble( D ); }

    public double getPower() { return power.getDouble( 0 ); }
    public void setPower( double P ) { power.setDouble( P ); }

}
