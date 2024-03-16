package frc.robot.Sensor;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Config.Ports.pSonar;

public class Sonar {

    public static Ultrasonic
        Frt = new Ultrasonic( pSonar.DIO_Frt[0], pSonar.DIO_Frt[1] ),
        Bck = new Ultrasonic( pSonar.DIO_Frt[0], pSonar.DIO_Frt[1] );

    public static void Initialize() {
        Ultrasonic.setAutomaticMode( true );
    }

    public static void Display() {
        SmartDashboard.putNumber( "Front (in)", Frt.getRangeInches() );
        SmartDashboard.putNumber( "Back (in)",  Bck.getRangeInches() );
    }

    public static double GetRangeBck() { return Bck.getRangeInches(); }
    public static double GetRangeFrt() { return Frt.getRangeInches(); }

}
