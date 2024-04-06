package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.mode.Teleoperate;

public class SplitStick extends Command {

  public SplitStick() {
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
