package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class comp_Spit_Ring extends Command {

  public comp_Spit_Ring() {
    addRequirements(
      RobotContainer.m_Intake,
      RobotContainer.m_Roller
    );
  }

  @Override public void execute() {
    RobotContainer.m_Roller.Reverse();
    RobotContainer.m_Intake.Spit();
  }

  @Override public boolean isFinished() {
    return true;
  }
}
