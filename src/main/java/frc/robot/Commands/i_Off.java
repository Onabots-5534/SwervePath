package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class i_Off extends InstantCommand {
  public i_Off() {
    addRequirements(
      RobotContainer.m_Climber,
      RobotContainer.m_Climber,
      RobotContainer.m_Flipper,
      RobotContainer.m_Intake,
      RobotContainer.m_Mover,
      RobotContainer.m_Roller,
      RobotContainer.m_Shooter
    );
  }

  @Override public void initialize() {
      RobotContainer.m_Climber  .Stop();
      RobotContainer.m_Climber  .Stop();
      // RobotContainer.m_Flipper
      RobotContainer.m_Intake   .Stop();
      RobotContainer.m_Mover    .Stop();
      RobotContainer.m_Roller   .Stop();
      RobotContainer.m_Shooter  .Stop();
  }
}
