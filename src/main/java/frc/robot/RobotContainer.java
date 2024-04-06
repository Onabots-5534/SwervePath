package frc.robot;

import com.pathplanner.lib.auto.NamedCommands;
// import com.pathplanner.lib.path.GoalEndState;
// import com.pathplanner.lib.path.PathConstraints;
// import com.pathplanner.lib.path.PathPlannerPath;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class RobotContainer {

  private Shared m_Shared;

  // CONTROLLERS
  private CommandPS4Controller  DS = null;
  private CommandXboxController MS = null;

  // SUBSYSTEMS
  private SubClimber m_Climber = null;
  private SubDrive   m_Drive   = null;
  private SubMover   m_Mover   = null;

  // SENSORS
  // public static final SubCameraIntake m_CamIntake  = new SubCameraIntake ();
  // public static final SubCameraTarget m_CamTarget  = new SubCameraTarget ();
  // public static final SubLED          m_Led        = new SubLED          ();
  // public static final SubNavigation   m_Navigation = new SubNavigation   ();
  // public static final SubSonar        m_Sonar      = new SubSonar        ();

  public RobotContainer() {

    m_Shared.initSubsystems();

    // REGISTER NAMED COMMANDS
    NamedCommands.registerCommand( "Seek and Destroy", new Seek_and_Destroy () );
    NamedCommands.registerCommand( "Shoot High",       new Shoot_High       () );

    // NamedCommands.registerCommand( "marker1",     Commands.print( "Passed marker 1") );
    // NamedCommands.registerCommand( "marker2",     Commands.print( "Passed marker 2") );
    // NamedCommands.registerCommand( "print hello", Commands.print( "hello" ) );

// ================ BINDINGS ====================

    m_Drive.setDefaultCommand( new SplitStick() );

    DS.R2()
      .onTrue ( new Seek_and_Destroy() );

// ==============================================

    MS.a()
      .onTrue ( new Shoot_Low           () );

    MS.b()
      .onTrue ( m_Mover.cReverse        () )
      .onFalse( m_Mover.cStop           () );

    MS.x()
      .onTrue ( new Collector_On        () )
      .onFalse( new Collector_Off       () );

    MS.y()
      .onTrue ( new Shoot_High          () );
   
    MS.start()
      .onTrue ( new Raise_Robot         () );

    MS.back()
      .onTrue ( new Raise_Arms          () );

    // RESET ARMS AFTER MATCH
    MS.leftBumper().and( MS.rightBumper () )
      .onTrue ( m_Climber.cLowerArms    () )
      .onFalse( m_Climber.cStop         () );

  }
}  

