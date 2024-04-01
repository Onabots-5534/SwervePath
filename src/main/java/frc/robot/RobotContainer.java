package frc.robot;

// import com.pathplanner.lib.auto.NamedCommands;
// import com.pathplanner.lib.path.GoalEndState;
// import com.pathplanner.lib.path.PathConstraints;
// import com.pathplanner.lib.path.PathPlannerPath;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.*;
import frc.robot.Config.Ports.pStick;
import frc.robot.Subsystems.*;

public class RobotContainer {

  // CONTROLLERS
  public static CommandPS4Controller  DS = new CommandPS4Controller ( pStick.USB_DS );
  public static CommandXboxController MS = new CommandXboxController( pStick.USB_MS );

  // SUBSYSTEMS
  // public static final SubAimer    m_Aimer    = new SubAimer   ();
  public static final SubClimber  m_Climber  = new SubClimber ();
  public static final SubDrive    m_Drive    = new SubDrive   ();
  public static final SubFlipper  m_Flipper  = new SubFlipper ();
  public static final SubIntake   m_Intake   = new SubIntake  ();
  public static final SubMover    m_Mover    = new SubMover   ();
  public static final SubRoller   m_Roller   = new SubRoller  ();
  public static final SubShooter  m_Shooter  = new SubShooter ();

  public static final CameraIntake m_CamIntake = new CameraIntake ();

  public RobotContainer() {
  
    // REGISTER NAMED COMMANDS
    // NamedCommands.registerCommand( "marker1",     Commands.print( "Passed marker 1") );
    // NamedCommands.registerCommand( "marker2",     Commands.print( "Passed marker 2") );
    // NamedCommands.registerCommand( "print hello", Commands.print( "hello" ) );

// ================ BINDINGS ====================

    m_Drive   .setDefaultCommand ( new Drive_By_Stick() );
    m_Intake  .setDefaultCommand ( m_Intake.cStop()     );
    m_Roller  .setDefaultCommand ( m_Roller.cStop()     );

    DS.circle()
      .onTrue ( new Attack_Ring() );

    DS.cross()
      .onTrue ( new Spit_Ring  () )
      .onFalse( new Cancel_All () );

// ==============================================

    MS.a() // TEMP: MOVE ROLLER
      .onTrue ( m_Roller.cForward () )
      .onFalse( m_Roller.cStop    () );

    MS.b() // TEMP: RUN INTAKE
      .onTrue ( m_Intake.cSuck () )
      .onFalse( m_Intake.cStop () );

    MS.y() // TEMP: COLLECTION SEQUENCE
      .onTrue ( new Collect_For_5() );

    // RESET ARMS AFTER MATCH
    MS.leftBumper().and( MS.rightBumper () )
      .onTrue ( m_Climber.cLowerArms    () )
      .onFalse( m_Climber.cStop         () );
  
    MS.start()
      .onTrue ( m_Climber.cRaiseArms() )
      .onFalse( m_Climber.cStop     () );

  } 

}
