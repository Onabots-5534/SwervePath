package frc.robot.support;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.Shared;
import frc.robot.board.CameraTab;

public class CameraIntake {

    public static NetworkTable
        NT = NetworkTableInstance.getDefault().getTable("limelight-intake");

    public static CameraTab
        SBT;

    public static double
        X = 0,
        Y = 0;

    public CameraIntake() {
        SBT = Shared.m_CameraTab;
    }

    public static void Display() {
        X = GetCode("tx");
        Y = GetCode("ty");
        SBT.setIntake( X, Y );
    }

    public static double GetCode( String S ) { return NT.getEntry( S ).getDouble( 0 ); }
}
