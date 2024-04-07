package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SubAimer;
import frc.robot.subsystems.SubMover;
import frc.robot.subsystems.SubRoller;
import frc.robot.subsystems.SubShooter;

public class Shoot_High extends SequentialCommandGroup {

    private SubAimer   m_Aimer   = null;
    private SubMover   m_Mover   = null;
    private SubRoller  m_Roller  = null;
    private SubShooter m_Shooter = null; 

  public Shoot_High() {

    m_Aimer   = RobotContainer.m_Aimer;
    m_Mover   = RobotContainer.m_Mover;
    m_Roller  = RobotContainer.m_Roller;
    m_Shooter = RobotContainer.m_Shooter;

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
