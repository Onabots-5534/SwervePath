package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.SubClimber;

public class Raise_Robot extends Command {

  private SubClimber m_Climber = null;

  public Raise_Robot() {

    // m_Climber = Shared.m_Climber;

    addRequirements(
      m_Climber
    );
  }

  @Override public void initialize() {}

  @Override public void execute() {
    m_Climber.LowerArms();
  }

  @Override public void end(boolean interrupted) {
    m_Climber.cStop();
  }

  @Override public boolean isFinished() {
    return m_Climber.GetDistance() <= 0 ? false : true;
  }
}
