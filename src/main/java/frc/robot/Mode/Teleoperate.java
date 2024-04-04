package frc.robot.Mode;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Config.Ports.pStick;

public class Teleoperate {

  public static PS4Controller  DS = new PS4Controller ( pStick.USB_DS );
  public static XboxController MS = new XboxController( pStick.USB_MS );

    public static void Initialize() {
        if ( Autonomous.m_autonomousCommand != null) {
            CommandScheduler.getInstance().cancelAll();
        }      
    }

    public static double
        X = 0,
        Y = 0,
        Z = 0;

    public static void Periodic() {
        X = Deadzone( -DS.getLeftY  () );
        Y = Deadzone( -DS.getLeftX  () );
        Z = Deadzone( -DS.getRightX () );
    }

    static double DZ = 0.07;

    public static double Deadzone( double V ) {
        return Math.abs(V)<DZ ? 0 : (V-Math.signum(V)*DZ) / (1-DZ); 
    } 

}
