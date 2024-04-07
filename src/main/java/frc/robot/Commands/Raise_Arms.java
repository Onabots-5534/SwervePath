package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SubClimber;

public class Raise_Arms extends Command {

  private SubClimber m_Climber = null;

  public Raise_Arms() {

    // m_Climber = Shared.m_Climber;

    // addRequirements(
    //   m_Climber
    // );
  }

  @Override public void initialize() {}

  @Override public void execute() {
    m_Climber.RaiseArms();
  }

  @Override public void end(boolean interrupted) {
    m_Climber.cStop();
  }

  @Override public boolean isFinished() {
    return m_Climber.GetDistance() >= -420 ? false : true;
  }
}
