package frc.robot.support;

import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.constants.Ports.pSonar;

public class Sonar {

    public static Ultrasonic
        Chute = new Ultrasonic( pSonar.DIO_Chute[0], pSonar.DIO_Chute[1] );

    public Sonar() {
        Ultrasonic.setAutomaticMode( true );

        Chute.setEnabled( true );
    }

}
