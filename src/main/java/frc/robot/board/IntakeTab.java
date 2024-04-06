package frc.robot.board;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class IntakeTab {

    public ShuffleboardTab
        SBT;

    GenericEntry
        enabled,
        power;

    public IntakeTab() {
        SBT = Shuffleboard.getTab("Collector");

        enabled = SBT.add( "Enabled", true  ).getEntry();
        power   = SBT.add( "Power",   power ).getEntry();
    }

    public void    SetEnabled( boolean flag ) { enabled.setBoolean( flag ); }
    public boolean GetEnabled() { return enabled.getBoolean( false ); }

    public void    SetPower( double Power ) { power.setDouble( Power ); }
    public double  GetPower() { return power.getDouble( 0 ); }
}
