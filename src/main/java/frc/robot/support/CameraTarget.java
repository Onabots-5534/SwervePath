package frc.robot.support;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.board.CameraTab;

public class CameraTarget {

    public static NetworkTable
        NT = NetworkTableInstance.getDefault().getTable("limelight-target");

    public static double
        X = 0,
        Y = 0;

    public CameraTarget() {
    }

    public static void Display() {
        X = GetCode("tx");
        Y = GetCode("ty");
        CameraTab.TargetX.setDouble( X );
        CameraTab.TargetY.setDouble( Y );
    }

    public static double GetCode( String S ) { return NT.getEntry( S ).getDouble( 0 ); }
}
