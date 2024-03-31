package frc.robot.Mode;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.Sensor.Alliance;
import frc.robot.Sensor.CameraIntake;
import frc.robot.Sensor.CameraTarget;
import frc.robot.Subsystems.SubIntake;

public class Onabot {

    public static GenericEntry
        RobotX = Shuffleboard.getTab("Comp").add( "Robot X", 0 ).getEntry(),
        RobotY = Shuffleboard.getTab("Comp").add( "Robot Y", 0 ).getEntry();

    public static void Initialize() {
        Robot.m_Container = new RobotContainer();

        CameraIntake.Initialize();
        CameraTarget.Initialize();

        SubIntake.Initialize();

        Shuffleboard.getTab("Comp").add( "Auton Selection", AutoBuilder.buildAutoChooser() )
            .withPosition( 9, 4 ).withSize( 2, 2);

        Shuffleboard.getTab("Comp").add("Test Auton", new PathPlannerAuto("Ctr-CBD") );
    }

    public static void Periodic() {
        CommandScheduler.getInstance().run();

        Alliance.Periodic();

        CameraIntake.Periodic();
        CameraTarget.Periodic();
    }

}
