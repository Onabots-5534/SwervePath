package frc.robot.Mode;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.RobotContainer;

public class Test {

    public static void Initialize() {
        CommandScheduler.getInstance().cancelAll();
    }

    public static void Periodic() {
        RobotContainer.m_Drive.DriveFieldRelative( new ChassisSpeeds( 0.15, 0.00, 0.00 ) );
    }

}
