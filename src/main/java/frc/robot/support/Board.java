package frc.robot.support;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.board.CameraTab;

public class Board {

  public static ShuffleboardTab
    tCamera,
    tCompetition;

  public static CameraTab CameraTab = new CameraTab();

  // public static AimerTab       Aimer       = null;
  // public static AutonomousTab  Autonomous  = null;
  // public static CameraTab t_CameraTab;
    // public static ClimberTab     Climber     = null;
  // public static CompetitionTab Competition = null;
  // public static IntakeTab      Collector   = null;
  // public static MoverTab       Mover       = null;
  // public static RollerTab      Roller      = null;
  // public static ShooterTab     Shooter     = null;

  public static void Initialize() {
      tCamera      = Shuffleboard.getTab("Camera");
      tCompetition = Shuffleboard.getTab("Competition");


    // Aimer       = new AimerTab();
    // Autonomous  = new AutonomousTab();
    // Climber     = new ClimberTab();
    // Collector   = new IntakeTab();
    // Competition = new CompetitionTab();
    // Mover       = new MoverTab();
    // Roller      = new RollerTab();
    // Shooter     = new ShooterTab();
  }

}
