package frc.robot.Mode;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class Onabot {

    public static ShuffleboardTab
        Auto = Shuffleboard.getTab( "Auto" ),
        Comp = Shuffleboard.getTab( "Comp" ),
        Test = Shuffleboard.getTab( "Test" );

    public static void Initialize() {
        Robot.m_Container = new RobotContainer();
    }

    public static void Periodic() {
        CommandScheduler.getInstance().run();
    }

}
