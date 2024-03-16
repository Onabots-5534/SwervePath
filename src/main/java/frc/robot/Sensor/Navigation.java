package frc.robot.Sensor;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
// import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Navigation {
    
    public static ADXRS450_Gyro
        NavX = new ADXRS450_Gyro();

    public static void Initialize() {
        NavX.calibrate();

    //     Shuffle.CompTab.add( NavX )
    //         .withPosition( 5, 2 )
    //         .withSize( 3, 3 )
    //         .withWidget( BuiltInWidgets.kGyro );
    }

    public static void Display() {
        SmartDashboard.putNumber( "Navigation Direction", GetDirection() );
    }

    public static void Periodic() {}

    public static double GetDirection() { 
        return ( GetYaw() + 360 ) % 360;
    }

    public static double GetError( double Heading ) {
        return ( Heading - NavX.getAngle() + 180 ) % 360 - 180;
    }

    public static void Calibrate() { NavX.calibrate(); }
    public static void Reset    () { NavX.reset    (); }

    // public static double GetPitch() { return +NavX.getPitch(); }
    // public static double GetRoll()  { return +NavX.getRoll();  }
    public static double GetYaw()   { return -NavX.getAngle();   }

}
