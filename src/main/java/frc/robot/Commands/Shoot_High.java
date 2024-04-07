package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Subsystems.SubAimer;
import frc.robot.Subsystems.SubMover;
import frc.robot.Subsystems.SubRoller;
import frc.robot.Subsystems.SubShooter;

public class Shoot_High extends SequentialCommandGroup {

    private SubAimer   m_Aimer   = null;
    private SubMover   m_Mover   = null;
    private SubRoller  m_Roller  = null;
    private SubShooter m_Shooter = null; 

  public Shoot_High() {

    // m_Aimer   = Shared.m_Aimer;
    // m_Mover   = Shared.m_Mover;
    // m_Roller  = Shared.m_Roller;
    // m_Shooter = Shared.m_Shooter;

    addCommands(

      new ParallelCommandGroup(
        m_Aimer.cRaise(),
        m_Shooter.cShoot( 1.00 )
      ).withTimeout( 0.25 ),

      new ParallelCommandGroup(
        m_Mover  .cForward(),
        m_Roller .cForward()
      ),

      new ParallelCommandGroup(
        m_Mover  .cStop(),
        m_Roller .cStop(),
        m_Shooter.cStop()
      )

    );
  }
}
