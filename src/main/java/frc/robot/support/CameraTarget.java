package frc.robot.support;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.Shared;
import frc.robot.board.CameraTab;

public class CameraTarget {

    public static NetworkTable
        NT = NetworkTableInstance.getDefault().getTable("limelight-target");

    public static CameraTab
        SBT;

    public static double
        X = 0,
        Y = 0;

    public CameraTarget() {
        SBT = Shared.m_CameraTab;
    }

    public static void Periodic() {
        X = GetCode("tx");
        Y = GetCode("ty");
        SBT.setTarget( X, Y );
    }

    public static double GetCode( String S ) { return NT.getEntry( S ).getDouble( 0 ); }
}
