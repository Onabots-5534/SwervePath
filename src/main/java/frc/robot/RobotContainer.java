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

  // ShuffleboardTab Auto = Shuffleboard.getTab( "Auto" );
  // ShuffleboardTab Comp = Shuffleboard.getTab( "Comp" );
  // ShuffleboardTab Driv = Shuffleboard.getTab( "Driv" );
  // ShuffleboardTab Mech = Shuffleboard.getTab( "Mech" );
  // ShuffleboardTab Pose = Shuffleboard.getTab( "Pose" );

  public RobotContainer() {
  
    // REGISTER NAMED COMMANDS
    NamedCommands.registerCommand( "marker1",     Commands.print( "Passed marker 1") );
    NamedCommands.registerCommand( "marker2",     Commands.print( "Passed marker 2") );
    NamedCommands.registerCommand( "print hello", Commands.print( "hello" ) );

// ==============================================
// ================ SHUFFLEBOARD ================
// ==============================================

    autoChooser = AutoBuilder.buildAutoChooser(); // Default auto will be `Commands.none()`


      // Add a button to run the example auto to SmartDashboard, this will also be in the auto chooser built above
      // SmartDashboard.putData( "Example Auto", new PathPlannerAuto("Example Auto") );
      // SmartDashboard.putData( "Ctr-C",        new PathPlannerAuto( "Ctr-C" )      );

      // Test.add( m_Aimer   ).withPosition(  0, 0 );
      // Test.add( m_Climber ).withPosition(  2, 0 );
      // Test.add( m_Drive   ).withPosition(  4, 0 );
      // Test.add( m_Flipper ).withPosition(  6, 0 );
      // Test.add( m_Intake  ).withPosition(  8, 0 );
      // Test.add( m_Mover   ).withPosition( 10, 0 );
      // Test.add( m_Roller  ).withPosition( 12, 0 );
      // Test.add( m_Shooter ).withPosition( 14, 0 );
      

      // Add a button to run pathfinding commands to SmartDashboard
      // Test.add( "Pickup Position",  NewPose.Absolute( 14.00, 6.50, 0 ) );
      // Test.add( "Scoring Position", NewPose.Absolute(  2.15, 3.00, 0 ) );

      // Add a button to run pathfinding commands to SmartDashboard
      // SmartDashboard.putData( "Pickup Position",  NewPose.Absolute( 14.00, 6.50, 0 ) );
      // SmartDashboard.putData( "Scoring Position", NewPose.Absolute(  2.15, 3.00, 0 ) );


// ==============================================
// ================ DRIVE STICK =================
// ==============================================

    // DS.circle().whileTrue( m_Drive.cRobotDrive( 0.30, 0.00, 0.00 ) );

// ==============================================
// ================ MANIP STICK =================
// ==============================================

  
  } 

  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }

}
