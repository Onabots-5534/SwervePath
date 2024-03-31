package frc.robot;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;

// import com.pathplanner.lib.path.GoalEndState;
// import com.pathplanner.lib.path.PathConstraints;
// import com.pathplanner.lib.path.PathPlannerPath;
// 
// import edu.wpi.first.math.geometry.Pose2d;
// import edu.wpi.first.math.geometry.Rotation2d;
// import edu.wpi.first.math.geometry.Translation2d;
// import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.RobotDrive;
import frc.robot.Config.Ports.pStick;
// import edu.wpi.first.wpilibj2.command.button.Trigger;
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

  public static SendableChooser<Command> autoChooser;

  public RobotContainer() {
  
    // REGISTER NAMED COMMANDS
    NamedCommands.registerCommand( "marker1",     Commands.print( "Passed marker 1") );
    NamedCommands.registerCommand( "marker2",     Commands.print( "Passed marker 2") );
    NamedCommands.registerCommand( "print hello", Commands.print( "hello" ) );

// ==============================================
// ================ SHUFFLEBOARD ================
// ==============================================

    autoChooser = AutoBuilder.buildAutoChooser(); // Default auto will be `Commands.none()`

// ==============================================
// ================ DRIVE STICK =================
// ==============================================

    m_Drive.setDefaultCommand( new RobotDrive() );

    // DS.circle().whileTrue( m_Drive.cRobotDrive( 0.30, 0.00, 0.00 ) );

// ==============================================
// ================ MANIP STICK =================
// ==============================================

  
  } 

  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }

}
