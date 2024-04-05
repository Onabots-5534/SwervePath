package frc.robot.Support;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configuration.Ports.pSwitch;

public class Switches extends SubsystemBase {

  public static DigitalInput
    Intake = new DigitalInput( pSwitch.DIO_Intake );

  public Switches() {

  }

  @Override public void periodic() {
  }

}
