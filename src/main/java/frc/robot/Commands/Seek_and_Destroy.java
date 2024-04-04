package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;

public class Seek_and_Destroy extends SequentialCommandGroup {

  public Seek_and_Destroy() {
    addCommands(

      new Attack_Translate(),

      new ParallelCommandGroup(
        RobotContainer.m_Drive  .cFieldDrive( 0.15, 0, 0 ),
        RobotContainer.m_Intake .cSuck(),
        RobotContainer.m_Roller .cForward()
      ).withTimeout( 0.5 ),

      new ParallelCommandGroup(
        RobotContainer.m_Drive  .cStop(),
        RobotContainer.m_Intake .cSuck(),
        RobotContainer.m_Roller .cForward()
      )

    );
  }
}