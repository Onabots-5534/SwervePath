package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.Sensor.CameraIntake;

public class Attack_Ring extends Command {

  public double
    TargetX = 0,
    TargetY = 0;

  public Attack_Ring() {
    addRequirements(
      RobotContainer.m_Drive,
      RobotContainer.m_Intake,
      RobotContainer.m_Roller
    );
  }

  @Override public void initialize() {
    RobotContainer.m_Roller.Forward();
    RobotContainer.m_Intake.Suck();
  }

  @Override public void execute() {
    double RingX = CameraIntake.X.getDouble( 0 );
    double RingY = CameraIntake.Y.getDouble( 0 );

    double DriveX = ( TargetX - RingX );
    double DriveY = ( TargetY - RingY );

    RobotContainer.m_Drive.RobotDrive( DriveX, DriveY, 0 );
  }

  @Override public void end( boolean interrupted ) {}

  @Override public boolean isFinished() {
    return false;
  }
}
