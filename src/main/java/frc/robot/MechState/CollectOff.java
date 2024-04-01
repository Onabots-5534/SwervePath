package frc.robot.MechState;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;


public class CollectOff extends InstantCommand {
  public CollectOff() {
    addRequirements( RobotContainer.m_Intake, RobotContainer.m_Roller );
  }

  @Override public void initialize() {
    RobotContainer.m_Intake.Stop();;
    RobotContainer.m_Roller.Stop();
  }

  @Override public void execute() {  }

}
