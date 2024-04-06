package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;

public class Shoot_Low extends SequentialCommandGroup {

  public Shoot_Low() {
    addCommands(

      new ParallelCommandGroup(
        RobotContainer.m_Aimer.cLower(),
        RobotContainer.m_Shooter.cShoot( 1.00 )
      ).withTimeout( 0.25 ),

      new ParallelCommandGroup(
        RobotContainer.m_Mover  .cForward(),
        RobotContainer.m_Roller .cForward()
      ),

      new ParallelCommandGroup(
        RobotContainer.m_Mover  .cStop(),
        RobotContainer.m_Roller .cStop(),
        RobotContainer.m_Shooter.cStop()
      )

    );
  }
}
