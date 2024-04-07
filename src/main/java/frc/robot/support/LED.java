package frc.robot.support;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Ports.pLED;

public class LED extends SubsystemBase {

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

    public static void Periodic() {}

    public static void SetColor() {
        for ( var i = 0; i < m_buf.getLength(); i++ ) { m_buf.setHSV( i, H, S, V ); }
        m_led.setData( m_buf );
    }

    public Command cOff   () { return this.runOnce( () -> Off() ); }
    public void     Off   () { H = 0; S = 0; V = 0; } 

    public Command cRed   () { return this.runOnce( () -> Red() ); }
    public void     Red   () { H = 0; S = 100; V = 100; }

    public Command cGreen () { return this.runOnce( () -> Green() ); }
    public void     Green () { H = 120; S = 100; V = 100; }

    public Command cBlue  () { return this.runOnce( () -> Blue() ); }
    public void     Blue  () { H = 240; S = 100; V = 100; }

    public Command cOn ( int[] C ) { return this.runOnce( () -> On( C ) ); }
    public void     On ( int[] C ) { H = C[0]; S = C[1]; V = C[2]; }     

}
