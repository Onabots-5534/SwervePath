package frc.robot.Mode;

public class Teleoperate {

    public static void Initialize() {
        if ( Autonomous.m_autonomousCommand != null) {
            Autonomous.m_autonomousCommand.cancel();
        }      
    }

    public static void Periodic() {
        
    }

}
