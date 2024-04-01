package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class Collection_Off extends InstantCommand {

  public Collection_Off() {
    addRequirements(
      RobotContainer.m_Intake,
      RobotContainer.m_Roller
    );
  }

  @Override public void initialize() {
    RobotContainer.m_Intake.Stop();
    RobotContainer.m_Roller.Stop();
  }

  @Override public void execute() {  }

}
