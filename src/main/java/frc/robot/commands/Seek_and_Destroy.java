package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Shared;
import frc.robot.subsystems.SubDrive;
import frc.robot.subsystems.SubIntake;
import frc.robot.subsystems.SubRoller;
import frc.robot.support.Switches;

public class Seek_and_Destroy extends SequentialCommandGroup {

  private SubDrive  m_Drive  = null;
  private SubIntake m_Intake = null;
  private SubRoller m_Roller = null;

  public Seek_and_Destroy() {

    m_Drive  = Shared.m_Drive;
    m_Intake = Shared.m_Intake;
    m_Roller = Shared.m_Roller;

    addCommands(

      new Attack_Translate(),

      new ParallelCommandGroup(
        m_Drive  .cFieldDrive( 0.25, 0, 0 ),
        m_Intake .cSuck(),
        m_Roller .cForward()
      ).until( Switches.Intake::get ).withTimeout( 0.50 ),

      new ParallelCommandGroup(
        m_Drive  .cStop(),
        m_Intake .cSuck(),
        m_Roller .cForward()
      )

    );
  }
}
