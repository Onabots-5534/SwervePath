package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Shared;
import frc.robot.subsystems.SubIntake;
import frc.robot.subsystems.SubRoller;

public class Collector_Off extends InstantCommand {

  private SubIntake m_Intake = null;
  private SubRoller m_Roller = null;

  public Collector_Off() {

    m_Intake = Shared.m_Intake;
    m_Roller = Shared.m_Roller;

    addRequirements(
      m_Intake,
      m_Roller
    );
  }

  @Override public void initialize() {
    m_Intake.Stop();
    m_Roller.Stop();
  }
}
