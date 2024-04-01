package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Config.Ports.pShooter;

public class SubShooter extends SubsystemBase {

  public SubShooter() {}

  public static TalonFX
    Lo = new TalonFX( pShooter.CAN_Lo ),
    Hi = new TalonFX( pShooter.CAN_Hi );

  public static double
    Power = 0;

  @Override public void periodic() {
    Lo.set( Power );
    Hi.set( Power );
  }

// ================ COMMANDS ====================

  public void     Shoot ( double power ) { Power = power; }
  public Command cShoot ( double power ) { return this.runOnce( () -> Shoot( power ) ); }

  public void     Stop ()                { Power = 0.00;  }
  public Command cStop ()                { return this.runOnce( () -> Stop()         ); } 
}
