package frc.robot.mode;

import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Test {

    public static void Initialize() {
        CommandScheduler.getInstance().cancelAll();
    }

    public static void Periodic() {
        // Shared.m_Drive.RobotDrive( 0.00, 0.00, 0.20 );
    }

}
