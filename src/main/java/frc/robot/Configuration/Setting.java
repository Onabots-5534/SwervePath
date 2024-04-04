package frc.robot.Configuration;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotContainer;
import frc.robot.Subsystems.SubDrive;

public class Setting {

    public static ShuffleboardTab
        Cfg = Shuffleboard.getTab("Config");

    public static GenericEntry
        SwerveRatio = Cfg.addPersistent( "EncoderRatio", 4.00 )
            .withPosition( 0, 0 )
            .withSize( 1, 1 )
            .getEntry();

    public static void Initialize() {
        Cfg.add( "Reset Encoder", RobotContainer.m_Drive.cResetEncoders() )
            .withPosition( 0, 1 )
            .withSize( 1, 1 );
    }

    public static void Periodic() {
        SmartDashboard.putNumber( "Rotations", SubDrive.Modules[0].Drive.getPosition().getValueAsDouble() );
    }
}