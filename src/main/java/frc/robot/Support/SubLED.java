package frc.robot.Support;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configuration.Ports.pLED;

public class SubLED extends SubsystemBase {

    public static AddressableLED
        m_led;

    public static AddressableLEDBuffer
        m_buf;

    public static int
        H = 0,
        S = 100,
        V = 100;    

    public static void Initialize() {
        m_led = new AddressableLED( pLED.PWM_LED );
        m_buf = new AddressableLEDBuffer( 60 );
        m_led.setLength( m_buf.getLength() );

        m_led.setData( m_buf );
        m_led.start();
    }

    public static void SetColor() {
        for ( var i = 0; i < m_buf.getLength(); i++ ) { m_buf.setHSV( i, H, S, V ); }
        m_led.setData( m_buf );
    }

    public Command     cRed   () { return this.runOnce( () -> Red() ); }
    public static void  Red   () { H =   0; }

    public Command     cGreen () { return this.runOnce( () -> Green() ); }
    public static void  Green () { H = 120; }

    public Command     cBlue  () { return this.runOnce( () -> Blue() ); }
    public static void  Blue  () { H = 240; }

}
