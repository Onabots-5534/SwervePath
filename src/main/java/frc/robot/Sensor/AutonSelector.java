package frc.robot.Sensor;

import java.util.List;

import com.pathplanner.lib.auto.AutoBuilder;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class AutonSelector {

    // public static String[] Track = {
    //     "Do Nothing",
    //     "Ctr-CBD",
    //     "New Auto"
    // };

    static List<String> T = AutoBuilder.getAllAutoNames();

    public static SendableChooser<String> m_Chooser = new SendableChooser<>();

    public static void Initialize() {

        m_Chooser.setDefaultOption( "Do Nothing", "" );

        for ( String e : T ) {
            m_Chooser.addOption( e, e );
        }

        // for ( int i = 1; i<Track.length; i++ ) {
        //     m_Chooser.addOption( Track[i], Track[i] );
        // }

        Shuffleboard.getTab("Comp").add( "Auton Selector", m_Chooser )
            .withWidget( BuiltInWidgets.kComboBoxChooser )
            .withPosition( 7, 4 ).withSize( 2, 1 );

        // SmartDashboard.putData( "Auto Auto", m_Chooser );
    }

}
