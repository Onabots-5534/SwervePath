package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.Mode.Teleoperate;

public class Drive_By_Stick extends Command {

  public Drive_By_Stick() {
    addRequirements( RobotContainer.m_Drive );
  }

  @Override public void initialize() {}

  @Override public void execute() {

    double
      X = Teleoperate.X,
      Y = Teleoperate.Y,
      Z = Teleoperate.Z;

    RobotContainer.m_Drive.RobotDrive( X, Y, Z );
  }

  @Override public void end( boolean interrupted ) {}

  @Override public boolean isFinished() {
    return false;
  }
}
