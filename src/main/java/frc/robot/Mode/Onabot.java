package frc.robot.Mode;

import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.Config.Config;
import frc.robot.Sensor.*;

public class Onabot {

    public static GenericEntry
        RobotX = Shuffleboard.getTab("Comp").add("Robot X",0).withPosition( 5, 5 ).withSize( 2, 1 ).getEntry(),
        RobotY = Shuffleboard.getTab("Comp").add("Robot Y",0).withPosition( 7, 5 ).withSize( 2, 1 ).getEntry();

    public static void Initialize() {
        Robot.m_Container = new RobotContainer();

        AutonSelector   .Initialize();
        CameraIntake    .Initialize();
        CameraTarget    .Initialize();
        Navigation      .Initialize();
        Config         .Initialize();

        Shuffleboard.getTab("Comp").add( "Test Auton", new PathPlannerAuto( "Ctr-CBD" ) );
    }

    public static void Periodic() {
        CommandScheduler.getInstance().run();

        Alliance        .Periodic();
        CameraIntake    .Periodic();
        CameraTarget    .Periodic();
        Navigation      .Periodic();
    }

}
