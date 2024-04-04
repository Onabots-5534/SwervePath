package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configuration.Ports.pAimer;

public class SubAimer extends SubsystemBase {

  public SubAimer() {}

  public static DoubleSolenoid
    Lft = new DoubleSolenoid( PneumaticsModuleType.CTREPCM, pAimer.PCM_Lft[0], pAimer.PCM_Lft[1] ),
    Rgt = new DoubleSolenoid( PneumaticsModuleType.CTREPCM, pAimer.PCM_Rgt[0], pAimer.PCM_Rgt[1] );

  public static DoubleSolenoid.Value
    Lower = DoubleSolenoid.Value.kForward,
    Raise = DoubleSolenoid.Value.kReverse,
    Off   = DoubleSolenoid.Value.kOff,
    State = Raise;

  @Override public void periodic() {
    Lft.set( State );
    Rgt.set( State );
  }

  public static void Display() {
    SmartDashboard.putString( "Aimer State", GetState() );
  }

  public static String GetState() { return State == Raise ? "Raise" : "Lower" ; }

// ================ COMMANDS ====================

  public void     Off  () { State = Off; }
  public Command cOff  () { return this.runOnce( () -> Off  () ); }   

  public void     Lower() { State = Lower; }
  public Command cLower() { return this.runOnce( () -> Lower() ); }

  public void     Raise() { State = Raise; }
  public Command cRaise() { return this.runOnce( () -> Raise() ); }
}
