package frc.robot.support;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.board.CameraTab;

public class CameraIntake {

    public static NetworkTable
        NT = NetworkTableInstance.getDefault().getTable("limelight-intake");

    public static double TX() { return GetCode("tx"); }
    public static double TY() { return GetCode("ty"); }

    public static double GetCode( String S ) { return NT.getEntry( S ).getDouble( 0 ); }
}
