package frc.robot.support;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Navigation {
    
    public static ADXRS450_Gyro
        NavX = new ADXRS450_Gyro();

    // public Navigation() {
    //     NavX.calibrate();
    // }

    public static void Initialize() {
        NavX.calibrate();
    }

    public static void Periodic() {}

    public static double GetDirection() { 
        return ( GetYaw() + 360 ) % 360;
    }

    // public static double GetError( double Heading ) {
    //     return ( Heading - NavX.getAngle() + 180 ) % 360 - 180;
    // }

    public static void Reset() { NavX.reset(); }

    // public static double GetPitch() { return +NavX.getPitch(); }
    // public static double GetRoll()  { return +NavX.getRoll();  }
    public static double GetYaw()   { return -NavX.getAngle();   }

}
