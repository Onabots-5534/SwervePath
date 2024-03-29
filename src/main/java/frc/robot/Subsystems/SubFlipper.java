package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Config.Ports.pFlipper;

public class SubFlipper extends SubsystemBase {

    public static Servo
        Flipper = new Servo( pFlipper.CAN_Servo );

    public static double
        State = 0;

    public SubFlipper() {

    }

    @Override public void periodic() {
        Flipper.set( State );
    }

    public static void Display() {
        SmartDashboard.putNumber( "Flipper State", State );
    }

// ================ COMMANDS ====================

    public static void Extend  () { State = 0; }
    public Command    cExtend  () { return this.runOnce( () -> Extend () ); }

    public static void Retract () { State = 1; }
    public Command    cRetract () { return this.runOnce( () -> Retract() ); }

}
