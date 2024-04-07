package frc.robot.mode;

import com.pathplanner.lib.auto.AutoBuilder;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.support.AutonSelector;

public class Autonomous {

    public static String
        m_autonomousCommand = "";

    public static void Initialize() {
        CommandScheduler.getInstance().cancelAll();

        m_autonomousCommand = AutonSelector.m_Chooser.getSelected();

        if ( m_autonomousCommand != "" ) {
            AutoBuilder.buildAuto( m_autonomousCommand ).schedule();
        }
    }

    public static void Periodic() {
    }

}
