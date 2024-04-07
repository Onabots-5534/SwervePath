package frc.robot.mode;

import com.pathplanner.lib.commands.PathPlannerAuto;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.Ssupport.*;
import frc.robot.Subsystems.SubDrive;

public class Onabot {

    // public static ShuffleboardTab
    //     Comp = Shuffleboard.getTab("Comp");

    // public static GenericEntry
    //     RobotX = Comp.add("Robot X",0).withPosition( 5, 5 ).withSize( 2, 1 ).getEntry(),
    //     RobotY = Comp.add("Robot Y",0).withPosition( 7, 5 ).withSize( 2, 1 ).getEntry();

    public static void Initialize() {

        Robot.m_Container = new RobotContainer();

        Board.Initialize();

        // CONFIG AND SENSORS
        Alliance        .Initialize();
        AutonSelector   .Initialize();
        // Setting         .Initialize();

        // ADDITIONAL COMMANDS
        Board.SBT_Competition.add( "Test Auton", new PathPlannerAuto( "Calibration" ) );

    }

    public static void Periodic() {

        CommandScheduler.getInstance().run();

        Board.Refresh();

        SubDrive.Display();

        // CONFIG AND SENSORS
        Alliance        .Periodic();
        AutonSelector   .Periodic();
        // Setting         .Periodic();

    }

}
