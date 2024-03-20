package frc.robot;

// import java.util.List;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
// import com.pathplanner.lib.commands.PathPlannerAuto;
// import com.pathplanner.lib.path.GoalEndState;
// import com.pathplanner.lib.path.PathConstraints;
// import com.pathplanner.lib.path.PathPlannerPath;

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
import frc.robot.Config.Bindings;
// import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Config.Ports.pStick;
import frc.robot.Subsystems.SubAimer;
import frc.robot.Subsystems.SubClimber;
import frc.robot.Subsystems.SubIntake;
import frc.robot.Subsystems.SubMover;
import frc.robot.Subsystems.SubRoller;
import frc.robot.Subsystems.SubShooter;
import frc.robot.Subsystems.SubDrive;
// import frc.robot.Support.NewPose;

public class RobotContainer {

  // SUBSYSTEMS
  public static final SubAimer    m_Aimer    = new SubAimer   ();
  public static final SubClimber  m_Climber  = new SubClimber ();
  public static final SubDrive    m_Drive    = new SubDrive   ();
  public static final SubIntake   m_Intake   = new SubIntake  ();
  public static final SubMover    m_Mover    = new SubMover   ();
  public static final SubRoller   m_Roller   = new SubRoller  ();
  public static final SubShooter  m_Shooter  = new SubShooter ();

  // CONTROLLERS
  public static CommandPS4Controller  DS = new CommandPS4Controller ( pStick.USB_DS );
  public static CommandXboxController MS = new CommandXboxController( pStick.USB_MS );

  private final SendableChooser<Command> autoChooser;

  public RobotContainer() {
  
    // REGISTER NAMED COMMANDS
    NamedCommands.registerCommand( "marker1",     Commands.print( "Passed marker 1") );
    NamedCommands.registerCommand( "marker2",     Commands.print( "Passed marker 2") );
    NamedCommands.registerCommand( "print hello", Commands.print( "hello" ) );

    // CONFIGURE BINDINGS
    Bindings.Shuffle();
    Bindings.Drive();
    Bindings.Manip();

    autoChooser = AutoBuilder.buildAutoChooser(); // Default auto will be `Commands.none()`
    SmartDashboard.putData( "Auton PathPlanner", autoChooser );
  } 

  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }
}
