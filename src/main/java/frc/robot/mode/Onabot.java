package frc.robot.mode;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.board.*;
import frc.robot.support.*;

public class Onabot {

    public static void Initialize() {

        Robot.m_Container = new RobotContainer();

        // CONFIG AND SENSORS
        Alliance        .Initialize();
        AutonSelector   .Initialize();
        LED             .Initialize();
        Navigation      .Initialize();
        Sonar           .Initialize();
        // Switches        .Initialize();

        // SHUFFLEBOARD TABS
        SBT_Climber     .Initialize();
        SBT_Competition .Initialize();
        SBT_Drivetrain  .Initialize();

    }

    public static void Periodic() {

        CommandScheduler.getInstance().run();

        // CONFIG AND SENSORS
        Alliance        .Periodic();
        AutonSelector   .Periodic();
        LED             .Periodic();
        Navigation      .Periodic();
        Sonar           .Periodic();
        // Switches        .Periodic();

        // SHUFFLEBOARD TABS
        SBT_Climber     .Periodic();
        SBT_Competition .Periodic();
        SBT_Drivetrain  .Periodic();
    }

}
