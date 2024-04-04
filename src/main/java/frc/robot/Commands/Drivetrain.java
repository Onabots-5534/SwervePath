package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.Mode.Teleoperate;

public class Drivetrain extends Command {

  public Drivetrain() {
    addRequirements( RobotContainer.m_Drive );
  }

  @Override public void execute() {

    double
      X = Teleoperate.X,
      Y = Teleoperate.Y,
      Z = Teleoperate.Z;

    RobotContainer.m_Drive.RobotDrive( X, Y, Z );
  }

}
