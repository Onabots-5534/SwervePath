package frc.robot.Mode;

import com.pathplanner.lib.auto.AutoBuilder;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Sensor.AutonSelector;

public class Autonomous {

    public static String  m_autonomousCommand = "";

    public static void Initialize() {

        m_autonomousCommand = AutonSelector.m_Chooser.getSelected();

        if ( m_autonomousCommand != "" ) {
            Command CMD = AutoBuilder.buildAuto( m_autonomousCommand );
            CMD.schedule();
        }
    }

    public static void Periodic() {
    }


}
