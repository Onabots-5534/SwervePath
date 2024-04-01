package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Config.Ports.pFlipper;

public class SubFlipper extends SubsystemBase {

    public static Servo
        Flipper = new Servo( pFlipper.PWM_Servo );

    public static double
        State = 0;

    public SubFlipper() {}

    @Override public void periodic() {
        Flipper.set( State );
    }

// ================ COMMANDS ====================

    public void     Extend  () { State = -0.5; }
    public Command cExtend  () { return this.runOnce( () -> Extend () ); }

    public void     Retract () { State = 0.77; }
    public Command cRetract () { return this.runOnce( () -> Retract() ); }
}
