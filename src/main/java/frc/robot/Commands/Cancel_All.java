package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class Cancel_All extends Command {

  public Cancel_All() {
    addRequirements(
      RobotContainer.m_Drive,
      RobotContainer.m_Intake,
      RobotContainer.m_Roller
    );
  }

  @Override public void initialize() {
    RobotContainer.m_Drive.cStop();
    RobotContainer.m_Intake.cStop();
    RobotContainer.m_Roller.cStop();
  }

}
