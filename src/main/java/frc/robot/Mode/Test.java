package frc.robot.Mode;

import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Test {

    public static void Initialize() {
        CommandScheduler.getInstance().cancelAll();
    }

    public static void Periodic() {

    }

}
