package frc.robot.mode;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Test {

    public static void Initialize() {
        CommandScheduler.getInstance().cancelAll();
    }

    public static void Periodic() {
        RobotContainer.m_Drive.RobotDrive( 1.00, 0.00, 0.00 );
    }

}
