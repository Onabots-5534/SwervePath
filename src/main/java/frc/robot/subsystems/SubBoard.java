package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.board.*;

public class SubBoard extends SubsystemBase {

  public AimerTab       Aimer       = null;
  public AutonomousTab  Autonomous  = null;
  public ClimberTab     Climber     = null;
  public CompetitionTab Competition = null;
  public IntakeTab      Collector   = null;
  public MoverTab       Mover       = null;
  public RollerTab      Roller      = null;
  public ShooterTab     Shooter     = null;

  public SubBoard() {
    Aimer       = new AimerTab();
    Autonomous  = new AutonomousTab();
    Climber     = new ClimberTab();
    Collector   = new IntakeTab();
    Competition = new CompetitionTab();
    Mover       = new MoverTab();
    Roller      = new RollerTab();
    Shooter     = new ShooterTab();
  }

  @Override public void periodic() {
  }
}
