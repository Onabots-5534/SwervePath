package frc.robot.Board;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class CollectorTab {

    ShuffleboardTab
        m_sbt_CollectorTab;
    
    GenericEntry
        enabled,
        power;

    private static CollectorTab
        instance = null;

    private CollectorTab() {
        initCollectorTab();
    }

    public static CollectorTab getInstance() {
        if ( instance == null ) { instance = new CollectorTab(); }
        return instance;
    }

    private void initCollectorTab() {
        m_sbt_CollectorTab = Shuffleboard.getTab("Collector");

        enabled = m_sbt_CollectorTab.add( "Enabled", true )
            .getEntry();
    }

    public void    SetEnabled( boolean flag ) { enabled.setBoolean( flag ); }
    public boolean GetEnabled() { return enabled.getBoolean( false ); }
}
