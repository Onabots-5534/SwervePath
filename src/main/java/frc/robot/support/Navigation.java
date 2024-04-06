package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.board.NavigationTab;

public class Navigation {
    
    public static ADXRS450_Gyro
        NavX = new ADXRS450_Gyro();

    public static NavigationTab    
        SBT;

    public Navigation() {
        NavX.calibrate();

        SBT = Shared.m_NavigationTab; 
        SBT.add( NavX )
            .withPosition( 5, 4 )
            .withSize( 3, 3 )
            .withWidget( BuiltInWidgets.kGyro );
    }

    public static double GetDirection() { 
        return ( GetYaw() + 360 ) % 360;
    }

    public static double GetError( double Heading ) {
        return ( Heading - NavX.getAngle() + 180 ) % 360 - 180;
    }

    public static void Reset    () { NavX.reset    (); }

    // public static double GetPitch() { return +NavX.getPitch(); }
    // public static double GetRoll()  { return +NavX.getRoll();  }
    public static double GetYaw()   { return -NavX.getAngle();   }

}
