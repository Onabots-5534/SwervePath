package frc.robot.Mode;

import com.pathplanner.lib.auto.AutoBuilder;
import frc.robot.Sensor.AutonSelector;

public class Autonomous {

    public static String
        m_autonomousCommand = "";

    public static void Initialize() {

        m_autonomousCommand = AutonSelector.m_Chooser.getSelected();

        if ( m_autonomousCommand != "" ) {
            AutoBuilder.buildAuto( m_autonomousCommand ).schedule();
        }
    }

    public static void Periodic() {
    }

}
