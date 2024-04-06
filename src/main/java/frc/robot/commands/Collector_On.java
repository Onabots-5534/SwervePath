package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class Collector_On extends InstantCommand {

  public Collector_On() {
    addRequirements(
      RobotContainer.m_Intake,
      RobotContainer.m_Roller
    );
  }

  @Override public void initialize() {
    RobotContainer.m_Intake.Suck();
    RobotContainer.m_Roller.Forward();
  }
}
