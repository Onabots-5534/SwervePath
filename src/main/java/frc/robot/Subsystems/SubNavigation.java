package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SubNavigation extends SubsystemBase {
    
    public static ADXRS450_Gyro
        NavX = new ADXRS450_Gyro();

    public static ShuffleboardTab    
        Comp = Shuffleboard.getTab("Comp");

    public SubNavigation() {
        NavX.calibrate();

        Comp.add( NavX )
            .withPosition( 5, 4 )
            .withSize( 3, 3 )
            .withWidget( BuiltInWidgets.kGyro );
    }

    @Override public void periodic() {}

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
