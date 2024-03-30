package frc.robot.Mode;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.RobotContainer;
import frc.robot.Config.Ports.pStick;
import frc.robot.Subsystems.*;

public class Teleoperate {

  public static PS4Controller  DS = new PS4Controller ( pStick.USB_DS );
  public static XboxController MS = new XboxController( pStick.USB_MS );

    public static void Initialize() {
        if ( Autonomous.m_autonomousCommand != null) {
            Autonomous.m_autonomousCommand.cancel();
        }      
    }

    public static void Periodic() {
        
        // GET JOYSTICK VALUES
        double
            X = -DS.getLeftY(),
            Y = -DS.getLeftX(),
            Z = -DS.getRightX();

        // JOYSTICK DEAD ZONE
        if ( Math.abs( X ) < 0.07 ) { X = 0; }
        if ( Math.abs( Y ) < 0.07 ) { Y = 0; }
        if ( Math.abs( Z ) < 0.07 ) { Z = 0; } else { Z /= 20; }

        // DRIVE THE ROBOT
        RobotContainer.m_Drive.FieldDrive( X, Y, Z );


        if ( MS.getAButton() ) {
            SubClimber.RaiseArms();
        }

        else if ( MS.getBButton() ) {
            SubClimber.LowerArms();
        }

        else {
            SubClimber.Stop();
        }
    }

}
