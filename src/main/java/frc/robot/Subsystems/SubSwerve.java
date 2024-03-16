package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SubSwerve extends SubsystemBase {

    public TalonFX
      Drive,
      Steer;

    public SubSwerve( int[] ID ) {
      Drive = new TalonFX( ID[0] );
      Steer = new TalonFX( ID[1] );
    }

  @Override public void periodic() {}

}
