package frc.robot.support;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.board.*;

public class Board {

  public static ShuffleboardTab
    tCamera,
    tCompetition,
    tDrivetrain;

  public static CameraTab      CameraTab      = new CameraTab();
  public static CompetitionTab CompetitionTab = new CompetitionTab();
  public static DrivetrainTab  DrivetrainTab  = new DrivetrainTab();

  public static void Initialize() {
      tCamera      = Shuffleboard.getTab("Camera");
      tCompetition = Shuffleboard.getTab("Competition");
      tDrivetrain  = Shuffleboard.getTab("Drivetrain"); 

    // Aimer       = new AimerTab();
    // Autonomous  = new AutonomousTab();
    // Climber     = new ClimberTab();
    // Collector   = new IntakeTab();
    // Competition = new CompetitionTab();
    // Mover       = new MoverTab();
    // Roller      = new RollerTab();
    // Shooter     = new ShooterTab();
  }

  public static void Refresh() {
    CameraTab.Refresh();
    DrivetrainTab.Refresh();
  }

}
