package frc.robot;

import com.pathplanner.lib.auto.NamedCommands;

// import com.pathplanner.lib.auto.NamedCommands;
// import com.pathplanner.lib.path.GoalEndState;
// import com.pathplanner.lib.path.PathConstraints;
// import com.pathplanner.lib.path.PathPlannerPath;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.*;
import frc.robot.Configuration.Ports.pStick;
import frc.robot.Subsystems.*;
import frc.robot.Support.SubLED;
import frc.robot.Support.SubSonar;

public class RobotContainer {

  // CONTROLLERS
  public static CommandPS4Controller  DS = new CommandPS4Controller ( pStick.USB_DS );
  public static CommandXboxController MS = new CommandXboxController( pStick.USB_MS );

  // SYSTEMS
  public static final SubAimer    m_Aimer    = new SubAimer   ();
  public static final SubClimber  m_Climber  = new SubClimber ();
  public static final SubDrive    m_Drive    = new SubDrive   ();
  public static final SubFlipper  m_Flipper  = new SubFlipper ();
  public static final SubIntake   m_Intake   = new SubIntake  ();
  public static final SubMover    m_Mover    = new SubMover   ();
  public static final SubRoller   m_Roller   = new SubRoller  ();
  public static final SubShooter  m_Shooter  = new SubShooter ();

  // SENSORS
  public static final SubCameraIntake m_CamIntake  = new SubCameraIntake ();
  public static final SubCameraTarget m_CamTarget  = new SubCameraTarget ();
  public static final SubLED          m_Led        = new SubLED          ();
  public static final SubNavigation   m_Navigation = new SubNavigation   ();
  public static final SubSonar        m_Sonar      = new SubSonar        ();

  public RobotContainer() {
  
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

    MS.a() // SHOOT LOW
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

