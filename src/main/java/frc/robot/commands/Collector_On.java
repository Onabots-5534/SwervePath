package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SubIntake;
import frc.robot.subsystems.SubRoller;

public class Collector_On extends InstantCommand {

  SubIntake m_Intake;
  SubRoller m_Roller;

  public Collector_On() {
    
    m_Intake = RobotContainer.m_Intake;
    m_Roller = RobotContainer.m_Roller;

    addRequirements(
      m_Intake,
      m_Roller
    );
  }

  @Override public void initialize() {
    m_Intake.Suck();
    m_Roller.Forward();
  }
}
