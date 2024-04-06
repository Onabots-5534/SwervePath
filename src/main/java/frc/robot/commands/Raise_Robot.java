package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class Raise_Robot extends Command {

  public Raise_Robot() {
    addRequirements(
      RobotContainer.m_Climber
    );
  }

  @Override public void initialize() {}

  @Override public void execute() {
    RobotContainer.m_Climber.LowerArms();
  }

  @Override public void end(boolean interrupted) {
    RobotContainer.m_Climber.cStop();
  }

  @Override public boolean isFinished() {
    return RobotContainer.m_Climber.GetDistance() <= 0 ? false : true;
  }
}
