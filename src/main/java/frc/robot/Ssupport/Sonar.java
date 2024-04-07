package frc.robot.Ssupport;

import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.Constants.Ports.pSonar;

public class Sonar {

    public static Ultrasonic
        Chute = new Ultrasonic( pSonar.DIO_Chute[0], pSonar.DIO_Chute[1] );

    public Sonar() {
        Ultrasonic.setAutomaticMode( true );

        Chute.setEnabled( true );
    }

}
