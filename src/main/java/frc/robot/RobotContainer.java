package frc.robot;

// import java.util.List;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
// import com.pathplanner.lib.commands.PathPlannerAuto;
// import com.pathplanner.lib.path.GoalEndState;
// import com.pathplanner.lib.path.PathConstraints;
// import com.pathplanner.lib.path.PathPlannerPath;
import com.pathplanner.lib.commands.PathPlannerAuto;

// import edu.wpi.first.math.geometry.Pose2d;
// import edu.wpi.first.math.geometry.Rotation2d;
// import edu.wpi.first.math.geometry.Translation2d;
// import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Config.Ports.pStick;
// import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Subsystems.SubAimer;
import frc.robot.Subsystems.SubClimber;
import frc.robot.Subsystems.SubIntake;
import frc.robot.Subsystems.SubMover;
import frc.robot.Subsystems.SubRoller;
import frc.robot.Subsystems.SubShooter;
import frc.robot.Support.NewPose;
import frc.robot.Subsystems.SubDrive;
// import frc.robot.Support.NewPose;

public class RobotContainer {

  // CONTROLLERS
  public static CommandPS4Controller  DS = new CommandPS4Controller ( pStick.USB_DS );
  public static CommandXboxController MS = new CommandXboxController( pStick.USB_MS );

  // SUBSYSTEMS
  public static final SubAimer    m_Aimer    = new SubAimer   ();
  public static final SubClimber  m_Climber  = new SubClimber ();
  public static final SubDrive    m_Drive    = new SubDrive   ();
  public static final SubIntake   m_Intake   = new SubIntake  ();
  public static final SubMover    m_Mover    = new SubMover   ();
  public static final SubRoller   m_Roller   = new SubRoller  ();
  public static final SubShooter  m_Shooter  = new SubShooter ();

  private final SendableChooser<Command> autoChooser;

  public RobotContainer() {
  
    // REGISTER NAMED COMMANDS
    NamedCommands.registerCommand( "marker1",     Commands.print( "Passed marker 1") );
    NamedCommands.registerCommand( "marker2",     Commands.print( "Passed marker 2") );
    NamedCommands.registerCommand( "print hello", Commands.print( "hello" ) );

    // CONFIGURE BINDINGS
    Shuffle();
    Drive();
    Manip();

    autoChooser = AutoBuilder.buildAutoChooser(); // Default auto will be `Commands.none()`
    SmartDashboard.putData( "Auton PathPlanner", autoChooser );
  } 

/*
 * SHUFFLEBOARD BUTTONS
 */
  public static void Shuffle() {
    // Add a button to run the example auto to SmartDashboard, this will also be in the auto chooser built above
    SmartDashboard.putData( "Example Auto", new PathPlannerAuto("Example Auto") );
    SmartDashboard.putData( "Ctr-C",        new PathPlannerAuto( "Ctr-C" )      );

    // Add a button to run pathfinding commands to SmartDashboard
    SmartDashboard.putData( "Pickup Position",  NewPose.Absolute( 14.00, 6.50, 0 ) );
    SmartDashboard.putData( "Scoring Position", NewPose.Absolute(  2.15, 3.00, 0 ) );
  }

/*
 * DRIVE STICK BINDINGS
 */
  public static void Drive() {
    DS.circle().onTrue( RobotContainer.m_Drive.cRobotDrive( 0.30, 0.00, 0.00 ) );
  }

/*
 * MANIP STICK BINDINGS
 */
  public static void Manip() {
  }

  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }
}
