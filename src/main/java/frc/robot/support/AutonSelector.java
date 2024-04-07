package frc.robot.support;

import java.util.List;
import java.util.stream.Collectors;
import com.pathplanner.lib.auto.AutoBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class AutonSelector {

    static List<String>
        T = AutoBuilder.getAllAutoNames()
        .stream().sorted().collect( Collectors.toList() );

    public static SendableChooser<String>
        m_Chooser = new SendableChooser<>();

    public static void Initialize() {
        m_Chooser.setDefaultOption( "Do Nothing", "" );
        for ( String e : T ) { m_Chooser.addOption( e, e ); }
    }

    public static void Periodic() {}
}
