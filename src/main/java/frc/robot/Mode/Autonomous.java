package frc.robot.Mode;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class Autonomous {

    public static Command m_autonomousCommand;

    public static void Initialize() {
        m_autonomousCommand = Robot.m_Container.getAutonomousCommand();
        if (m_autonomousCommand != null) { m_autonomousCommand.schedule(); }
    }

    public static void Periodic() {
    }


}
