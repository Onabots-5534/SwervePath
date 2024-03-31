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
        
        // GET JOYSTICK VALUES
        X = -DS.getLeftY();
        Y = -DS.getLeftX();
        Z = -DS.getRightX();

        // JOYSTICK DEAD ZONE
        if ( Math.abs( X ) < 0.07 ) { X = 0; }
        if ( Math.abs( Y ) < 0.07 ) { Y = 0; }
        if ( Math.abs( Z ) < 0.07 ) { Z = 0; } else { Z /= 20; }

        // DRIVE THE ROBOT
        // RobotContainer.m_Drive.FieldDrive( X, Y, Z );


        if ( MS.getAButton() ) {
            // RobotContainer.m_Aimer.Raise();
        }

        else {
            // RobotContainer.m_Aimer.Lower();
        }
    }

}
