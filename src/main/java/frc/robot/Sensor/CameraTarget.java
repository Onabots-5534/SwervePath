package frc.robot.Sensor;

import java.util.Map;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class CameraTarget {

    public static NetworkTable
        CamS = NetworkTableInstance.getDefault()
            .getTable("limelight-target");

    public static ShuffleboardTab
        Comp = Shuffleboard.getTab( "Comp" );

    public static GenericEntry
        X = Comp.add( "Target TX", 0 ).withPosition( 11, 0 ).withSize( 2, 1 ).getEntry(),
        Y = Comp.add( "Target TY", 0 ).withPosition( 11, 3 ).withSize( 2, 1 ).getEntry();

    public static void Initialize() {
        Comp.addCamera( "Camera Shooter", "Limelight 2", "http://10.55.34.12:5800" )
            .withPosition( 11, 0 )
            .withProperties( Map.of( "showControls", false ) )
            .withSize( 5, 5 );
    }

    public static void Periodic() {
        X.setDouble( GetCode("tx") );
        Y.setDouble( GetCode("ty") );
    }

    public static void Reset() {}

    public static double GetCode( String S ) { return CamS.getEntry( S ).getDouble( 0 ); }
}
