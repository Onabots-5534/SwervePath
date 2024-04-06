package frc.robot.commands;

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
    RobotContainer.m_Climber.RaiseArms();
  }

  @Override public void end(boolean interrupted) {
    RobotContainer.m_Climber.cStop();
  }

  @Override public boolean isFinished() {
    return RobotContainer.m_Climber.GetDistance() >= -420 ? false : true;
  }
}
