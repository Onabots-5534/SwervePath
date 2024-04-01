package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;


public class Collection_On extends InstantCommand {
  public Collection_On() {
    addRequirements( RobotContainer.m_Intake, RobotContainer.m_Roller );
  }

  @Override public void initialize() {
    RobotContainer.m_Intake.Suck();
    RobotContainer.m_Roller.Forward();
  }

  @Override public void execute() {
    RobotContainer.m_Intake.Suck();
    RobotContainer.m_Roller.Forward();
  }

}
