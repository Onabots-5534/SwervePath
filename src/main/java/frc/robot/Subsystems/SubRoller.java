package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Config.Ports.pRoller;

public class SubRoller extends SubsystemBase {

  public static TalonSRX
    Roller = new TalonSRX( pRoller.CAN_Roller );

  public static double
    Power = 0;

  public SubRoller() {}

  @Override public void periodic() {
    Roller.set( TalonSRXControlMode.PercentOutput, Power );
  }
  
  public static void Display() {
    SmartDashboard.putNumber( "Roller Power", Power );
  }

// ================ COMMANDS ====================

  public void     Forward () { Power = -0.50; }
  public Command cForward () { return this.runOnce( () -> Forward () ); }

  public void     Reverse () { Power =  0.50; }
  public Command cReverse () { return this.runOnce( () -> Reverse () ); }

  public void     Stop    () { Power =  0.00; }
  public Command cStop    () { return this.runOnce( () -> Stop    () ); }
}
