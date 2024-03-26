package frc.robot.Mode;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.RobotContainer;
import frc.robot.Config.Ports.pStick;

public class Teleoperate {

  public static XboxController MS = new XboxController( pStick.USB_MS );

    public static void Initialize() {
        if ( Autonomous.m_autonomousCommand != null) {
            Autonomous.m_autonomousCommand.cancel();
        }      
    }

    public static void Periodic() {
        
        if ( MS.getAButton() ) {
            RobotContainer.m_Drive.FieldDrive( 0.80, 0, 0 );
        }

        else if ( MS.getBButton() ) {
            RobotContainer.m_Drive.FieldDrive( 0.00, 0.80, 0 );
        }

        else {
            RobotContainer.m_Drive.FieldDrive( 0, 0, 0 );
        }
    }

}
