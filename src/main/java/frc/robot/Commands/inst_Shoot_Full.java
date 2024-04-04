package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;

public class inst_Shoot_Full extends InstantCommand {

  public inst_Shoot_Full() {
    addRequirements(
      RobotContainer.m_Shooter
    );
  }

  @Override public void initialize() {
    RobotContainer.m_Shooter.Shoot( 1.00 );
  }

}
