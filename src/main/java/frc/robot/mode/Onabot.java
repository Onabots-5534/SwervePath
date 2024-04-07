package frc.robot.mode;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.board.*;
import frc.robot.subsystems.SubDrive;
import frc.robot.support.*;

public class Onabot {

    public static void Initialize() {

        Robot.m_Container = new RobotContainer();

        // CONFIG AND SENSORS
        Alliance        .Initialize();
        AutonSelector   .Initialize();
        // Setting         .Initialize();

        // SHUFFLEBOARD TABS
        SBT_Competition .Initialize();

    }

    public static void Periodic() {

        CommandScheduler.getInstance().run();


        SubDrive.Display();

        // CONFIG AND SENSORS
        Alliance        .Periodic();
        AutonSelector   .Periodic();
        // Setting         .Periodic();

        // SBT_Climber     .Periodic();
        SBT_Competition .Periodic();
    }

}
