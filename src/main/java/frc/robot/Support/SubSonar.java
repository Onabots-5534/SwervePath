package frc.robot.Support;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configuration.Ports.pSonar;

public class SubSonar extends SubsystemBase {

    public static Ultrasonic
        Chute = new Ultrasonic( pSonar.DIO_Chute[0], pSonar.DIO_Chute[1] );

    public SubSonar() {
        Ultrasonic.setAutomaticMode( true );

        Chute.setEnabled( true );
    }

    @Override public void periodic() {
        SmartDashboard.putNumber( "Chute", Chute.getRangeInches() );
    }

    public static double GetRangeFrt() { return Chute.getRangeInches(); }

}
