package frc.robot.Support;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configuration.Ports.pSonar;

public class SubSonar extends SubsystemBase {

    public static Ultrasonic
        Frt = new Ultrasonic( pSonar.DIO_Frt[0], pSonar.DIO_Frt[1] ),
        Bck = new Ultrasonic( pSonar.DIO_Frt[0], pSonar.DIO_Frt[1] );

    public SubSonar() {
        Ultrasonic.setAutomaticMode( true );

        Frt.setEnabled( true );
        Bck.setEnabled( true );
    }

    @Override public void periodic() {
        SmartDashboard.putNumber( "Front (in)", Frt.getRangeInches() );
        SmartDashboard.putNumber( "Back (in)",  Bck.getRangeInches() );
    }

    public static double GetRangeBck() { return Bck.getRangeInches(); }
    public static double GetRangeFrt() { return Frt.getRangeInches(); }

}
