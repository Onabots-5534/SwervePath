package frc.robot.support;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.board.*;

public class Board {

  public static ShuffleboardTab
    SBT_Competition,
    SBT_Drivetrain;

  public static CompetitionTab CompetitionTab = new CompetitionTab();
  public static DrivetrainTab  DrivetrainTab  = new DrivetrainTab();

  public static void Initialize() {
      SBT_Competition = Shuffleboard.getTab("Competition");
      SBT_Drivetrain  = Shuffleboard.getTab("Drivetrain"); 

    // Aimer       = new AimerTab();
    // Autonomous  = new AutonomousTab();
    // Climber     = new ClimberTab();
    // Collector   = new IntakeTab();
    // Mover       = new MoverTab();
    // Roller      = new RollerTab();
    // Shooter     = new ShooterTab();
  }

  public static void Refresh() {
    ClimberTab    .Refresh();
    DrivetrainTab .Refresh();
  }

}
