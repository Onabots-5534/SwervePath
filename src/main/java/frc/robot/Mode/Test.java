package frc.robot.Mode;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.RobotContainer;
import frc.robot.Sensor.Shuffle;

public class Test {

    public static GenericEntry TEST = Shuffle.TestTab.add( "VALUE", 0 ).getEntry();

    public static void Initialize() {
        CommandScheduler.getInstance().cancelAll();
    }

    public static void Periodic() {
        RobotContainer.m_Drive.RobotDrive( 0.00, 0.00, 0.20 );
    }

}
