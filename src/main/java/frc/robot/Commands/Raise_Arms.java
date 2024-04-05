package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class Raise_Arms extends Command {

  public Raise_Arms() {
    addRequirements(
      RobotContainer.m_Climber
    );
  }

  @Override public void initialize() {}

  @Override public void execute() {
    SubClimber.Climber.
  }

  @Override public void end(boolean interrupted) {}

  @Override public boolean isFinished() {
    return false;
  }
}
