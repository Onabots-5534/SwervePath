package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class Spit_Ring extends Command {

  public double
    TargetX = 0,
    TargetY = 2;

  public Spit_Ring() {
    addRequirements(
      RobotContainer.m_Drive,
      RobotContainer.m_Intake,
      RobotContainer.m_Roller
    );
  }

  @Override public void initialize() {
    RobotContainer.m_Roller.Reverse();
    RobotContainer.m_Intake.Spit();
  }

  @Override public void execute() {
    RobotContainer.m_Roller.Reverse();
    RobotContainer.m_Intake.Spit();
  }

  @Override public void end( boolean interrupted ) {
      RobotContainer.m_Drive   .Stop();
      RobotContainer.m_Intake  .Stop();
      RobotContainer.m_Roller  .Stop();
  }

  @Override public boolean isFinished() {
    return false;
  }
}
