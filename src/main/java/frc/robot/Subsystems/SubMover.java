package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Config.Ports.pMover;

public class SubMover extends SubsystemBase {

  public SubMover() {}

  public static CANSparkMax
    Mover = new CANSparkMax( pMover.CAN_Mover, MotorType.kBrushless );

  public static double
    Power = 0;

  @Override public void periodic() {
    Mover.set( Power );
  }

// ================ COMMANDS ====================

  public void     Forward () { Power =  0.50; }
  public Command cForward () { return this.runOnce( () -> Forward() ); }

  public void     Reverse () { Power = -0.40; }
  public Command cReverse () { return this.runOnce( () -> Reverse() ); }

  public void     Stop    () { Power =  0.00; }
  public Command cStop    () { return this.runOnce( () -> Stop   () ); }
}
