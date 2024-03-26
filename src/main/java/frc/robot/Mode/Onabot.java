package frc.robot.Mode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.Sensor.Shuffle;
import frc.robot.Subsystems.SubDrive;

public class Onabot {

    public static void Initialize() {
        Robot.m_Container = new RobotContainer();

        Shuffle.Initialize();
    }

    public static void Periodic() {
        CommandScheduler.getInstance().run();

        SmartDashboard.putNumber( "FL Dir PV", SubDrive.Modules[2].Encod.getPosition().getValueAsDouble() );
        SmartDashboard.putNumber( "FL Dir SP", SubDrive.Modules[2].currentVelocity.angle.getRotations() );
    }

}
