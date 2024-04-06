package frc.robot.support;

import frc.robot.board.*;

public class Board {

  public static AimerTab       Aimer       = null;
  public static AutonomousTab  Autonomous  = null;
  public static ClimberTab     Climber     = null;
  public static CompetitionTab Competition = null;
  public static IntakeTab      Collector   = null;
  public static MoverTab       Mover       = null;
  public static RollerTab      Roller      = null;
  public static ShooterTab     Shooter     = null;

  public static void Initialize() {
    Aimer       = new AimerTab();
    Autonomous  = new AutonomousTab();
    Climber     = new ClimberTab();
    Collector   = new IntakeTab();
    Competition = new CompetitionTab();
    Mover       = new MoverTab();
    Roller      = new RollerTab();
    Shooter     = new ShooterTab();
  }

}
