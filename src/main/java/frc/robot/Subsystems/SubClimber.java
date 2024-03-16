package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Config.Ports.pClimber;

public class SubClimber extends SubsystemBase {

  public static CANSparkMax
    Climber = new CANSparkMax( pClimber.CAN_Climber, MotorType.kBrushless );

  public static double
    Power = 0;

  public SubClimber() {
    Climber.restoreFactoryDefaults();
    Climber.setInverted( false );
  }

  @Override public void periodic() {
    Climber.set( Power );
  }

  public static void Display() {
    SmartDashboard.putNumber( "Climber Power", Power );
  }

// ================ COMMANDS ====================

  public static void RaiseArms() { Power =  0.80; }
  public Command    cRaiseArms() { return this.runOnce( () -> RaiseArms() ); }

  public static void LowerArms() { Power = -0.50; }
  public Command    cLowerArms() { return this.runOnce( () -> LowerArms() ); }
}
