package frc.robot.support;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class CameraTarget {

    public static NetworkTable
        NT = NetworkTableInstance.getDefault().getTable("limelight-target");

    public static double TX() { return GetCode("tx"); }
    public static double TY() { return GetCoce("ty"); }
    
    public static double GetCode( String S ) { return NT.getEntry( S ).getDouble( 0 ); }
}
