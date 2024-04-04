package frc.robot.Sensor;

import java.util.Map;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class CameraIntake {

    public static NetworkTable
        CamI = NetworkTableInstance.getDefault().getTable("limelight-intake");

    public static ShuffleboardTab    
        Comp = Shuffleboard.getTab("Comp");

    public static GenericEntry
        X = Comp.add( "Intake TX", 0 ).withPosition( 0, 5 ).withSize( 2, 1 ).getEntry(),
        Y = Comp.add( "Intake TY", 0 ).withPosition( 3, 5 ).withSize( 2, 1 ).getEntry();

    public static double
        Xi = 0,
        Yi = 0;

    public static void Initialize() {
      Comp.addCamera( "Intake Camera", "Limelight 3", "http://10.55.34.13:5800" )
        .withPosition( 0, 0 )
        .withProperties( Map.of( "showControls", false ) )
        .withSize( 5, 5 )
        .withWidget( BuiltInWidgets.kCameraStream );
    }


    public static void Periodic() {
        X.setDouble( GetCode( "tx" ) );
        Y.setDouble( GetCode( "ty" ) );

        Xi = GetCode("tx");
        Yi = GetCode("ty");
    }

    public static void Reset() {}

    public static double GetCode( String S ) { return CamI.getEntry( S ).getDouble( 0 ); }
}
