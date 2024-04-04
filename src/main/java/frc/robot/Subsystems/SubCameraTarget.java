package frc.robot.Subsystems;

import java.util.Map;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SubCameraTarget extends SubsystemBase {

    public static NetworkTable
        NT = NetworkTableInstance.getDefault().getTable("limelight-target");

    public static ShuffleboardTab
        Comp = Shuffleboard.getTab( "Comp" );

    public static GenericEntry
        X = Comp.add( "Target TX", 0 ).withPosition( 11, 5 ).withSize( 2, 1 ).getEntry(),
        Y = Comp.add( "Target TY", 0 ).withPosition( 14, 5 ).withSize( 2, 1 ).getEntry();

    public SubCameraTarget() {
        Comp.addCamera( "Camera Shooter", "Limelight 2", "http://10.55.34.12:5800" )
            .withPosition( 11, 0 )
            .withProperties( Map.of( "showControls", false ) )
            .withSize( 5, 5 )
            .withWidget( BuiltInWidgets.kCameraStream );
    }

    @Override public void periodic() {
        X.setDouble( GetCode("tx") );
        Y.setDouble( GetCode("ty") );
    }

    public static double GetCode( String S ) { return NT.getEntry( S ).getDouble( 0 ); }
}
