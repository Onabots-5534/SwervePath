package frc.robot.support;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.board.*;

public class Board {

  public static ShuffleboardTab
    tCompetition,
    tDrivetrain;

  public static CompetitionTab CompetitionTab = new CompetitionTab();
  public static DrivetrainTab  DrivetrainTab  = new DrivetrainTab();

  public static void Initialize() {
      tCompetition = Shuffleboard.getTab("Competition");
      tDrivetrain  = Shuffleboard.getTab("Drivetrain"); 

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
