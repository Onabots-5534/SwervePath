package frc.robot.board;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class CompetitionTab {

    public ShuffleboardTab
        SBT;

    public static GenericEntry
        RobotX,
        RobotY;

    public CompetitionTab() {
        SBT = Shuffleboard.getTab("Competition");

        RobotX = SBT.add("Robot X",0).withPosition( 5, 0 ).withSize( 2, 1 ).getEntry();
        RobotY = SBT.add("Robot Y",0).withPosition( 5, 1 ).withSize( 2, 1 ).getEntry();
    }

    public static void SetRobotPos( double X, double Y ) {
        RobotX.setDouble( X );
        RobotY.setDouble( Y );
    }

    // public void setRobotX( double X ) { RobotX.setDouble(X); }
    // public void setRobotY( double Y ) { RobotX.setDouble(Y); }

}
