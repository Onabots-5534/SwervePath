package frc.robot.support;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.board.CameraTab;

public class CameraIntake {

    public static NetworkTable
        NT = NetworkTableInstance.getDefault().getTable("limelight-intake");

    public static double
        X = 0,
        Y = 0;

    public CameraIntake() {
    }

    public static void Display() {
        X = GetCode("tx");
        Y = GetCode("ty");
        CameraTab.IntakeX.setDouble( X );
        CameraTab.IntakeY.setDouble( Y );
    }

    public static double GetCode( String S ) { return NT.getEntry( S ).getDouble( 0 ); }
}
