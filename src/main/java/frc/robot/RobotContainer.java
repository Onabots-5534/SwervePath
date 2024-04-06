package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.*;
import frc.robot.constants.Ports.pStick;
import frc.robot.subsystems.*;
import frc.robot.support.*;

import com.pathplanner.lib.auto.NamedCommands;
// import com.pathplanner.lib.path.GoalEndState;
// import com.pathplanner.lib.path.PathConstraints;
// import com.pathplanner.lib.path.PathPlannerPath;

public class RobotContainer {

  // CONTROLLERS
  private CommandPS4Controller  DS = new CommandPS4Controller ( pStick.USB_DS );
  private CommandXboxController MS = new CommandXboxController( pStick.USB_MS );

  // SENSORS AND SUPPORT
  public static final CameraIntake  m_CamIntake  = new CameraIntake ();
  public static final CameraTarget  m_CamTarget  = new CameraTarget ();
  public static final Navigation    m_Navigation = new Navigation   ();
  // public static final SubLED          m_Led        = new SubLED          ();
  // public static final SubSonar        m_Sonar      = new SubSonar        ();

  // SUBSYSTEM MECHANISMS
  public static SubAimer   m_Aimer   = new SubAimer();
  public static SubClimber m_Climber = new SubClimber();
  public static SubDrive   m_Drive   = new SubDrive();
  public static SubIntake  m_Intake  = new SubIntake();
  public static SubMover   m_Mover   = new SubMover();
  public static SubRoller  m_Roller  = new SubRoller();
  public static SubShooter m_Shooter = new SubShooter();


  public RobotContainer() {

    // REGISTER NAMED COMMANDS
    NamedCommands.registerCommand( "Seek and Destroy", new Seek_and_Destroy () );
    // NamedCommands.registerCommand( "Shoot High",       new Shoot_High       () );

    NamedCommands.registerCommand( "marker1",     Commands.print( "Passed marker 1") );
    NamedCommands.registerCommand( "marker2",     Commands.print( "Passed marker 2") );
    NamedCommands.registerCommand( "print hello", Commands.print( "hello" ) );

// ================ BINDINGS ====================

    m_Drive.setDefaultCommand( new SplitStick() );

    DS.R2()
      .onTrue ( new Seek_and_Destroy() );

// ==============================================

    // MS.a()
    //   .onTrue ( new Shoot_Low           () );

    MS.b()
      .onTrue ( m_Mover.cReverse        () )
      .onFalse( m_Mover.cStop           () );

    MS.x()
      .onTrue ( new Collector_On        () )
      .onFalse( new Collector_Off       () );

    // MS.y()
    //   .onTrue ( new Shoot_High          () );
   
    // MS.start()
    //   .onTrue ( new Raise_Robot         () );

    // MS.back()
    //   .onTrue ( new Raise_Arms          () );

    // // RESET ARMS AFTER MATCH
    // MS.leftBumper().and( MS.rightBumper () )
    //   .onTrue ( m_Climber.cLowerArms    () )
    //   .onFalse( m_Climber.cStop         () );

  }
}  

