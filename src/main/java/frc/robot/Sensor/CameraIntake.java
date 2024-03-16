package frc.robot.Sensor;

import java.util.Map;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CameraIntake extends SubsystemBase {

    public static NetworkTable
        CamI = NetworkTableInstance.getDefault().getTable("limelight-intake");
    
    public static GenericEntry
        IntakeTX = Shuffle.CompTab.add( "Intake TX", 0 )
            .withPosition( 5, 0 )
            .withSize( 2, 1 )
            .getEntry(),

        IntakeTY = Shuffle.CompTab.add( "Intake TY", 0 )
            .withPosition( 5, 1 )
            .withSize( 2, 1 )
            .getEntry();

    public static void Initialize() {
        Shuffle.CompTab.addCamera( "Camera Intake", "Limelight 3", "http://10.55.34.13:5800" )
            .withPosition( 0, 0 )
            .withProperties( Map.of( "showControls", false ) )
            .withSize( 5, 5 )
            .withWidget( BuiltInWidgets.kCameraStream );
     }

    public static void Periodic() {
        IntakeTX.setDouble( GetCode( "tx" ) );
        IntakeTY.setDouble( GetCode( "ty" ) );
    }

    public static void Reset() {}

    public static double GetCode( String S ) { return CamI.getEntry( S ).getDouble( 0 ); }

    public static double TX() { return GetCode("tx"); }
    public static double TY() { return GetCode("ty"); }
    public static double TV() { return GetCode("tv"); }

    public static double GetErr( String Code, double Desired ) {
        return Desired - GetCode( Code );
    }

}
