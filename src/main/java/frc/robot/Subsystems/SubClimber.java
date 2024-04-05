package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configuration.Ports.pClimber;

public class SubClimber extends SubsystemBase {

  public static TalonFX
    Climber = new TalonFX( pClimber.CAN_Climber );

  public static double
    Power = 0;

  public SubClimber() {
    Climber.setInverted( false );
  }

  @Override public void periodic() {
    Climber.set( Power );
  }

  public static void Display() {
    SmartDashboard.putNumber( "Climber Power", Power );
  }

  public double GetDistance() {
    return Climber.getPosition().getValueAsDouble();
  }

// ================ COMMANDS ====================

  public void     LowerArms    () { Power =  0.50; }
  public Command cLowerArms    () { return this.runOnce( () -> LowerArms() ); }

  public void     RaiseArms    () { Power = -0.80; }
  public Command cRaiseArms    () { return this.runOnce( () -> RaiseArms() ); }

  public void     ResetEncoder () {}
  public Command cResetEncoder () { return this.runOnce( () -> ResetEncoder() ); }

  public void     Stop         () { Power = 0.00; }
  public Command cStop         () { return this.runOnce( () -> Stop() ); }

// TODO Need to implement Raising and Lowering the Robot Climber Arms
/* These functions will raise or lower the robot until the encoder value reaches a specific
  * SetPoint and then stop. This prevents the climber arms from overextending themselves.
  * This should read the encoder and check its value. There should also be a button on the
  * Shuffleboard that resets the encoder.
  */

  // These should actually be moved out of this file and made into a more complex command.
  public void     RaiseRobot   () { LowerArms();                                 }
  public Command cRaiseRobot   () { return this.runOnce( () -> LowerArms()    ); }

  public void     LowerRobot   () { RaiseArms();                                 }
  public Command cLowerRobot   () { return this.runOnce( () -> RaiseArms()    ); }
}
