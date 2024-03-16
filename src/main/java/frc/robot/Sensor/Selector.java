package frc.robot.Sensor;

import edu.wpi.first.wpilibj.DriverStation;

public class Selector {

//
// ALLIANCE COLOR
//
    public static String GetAlliance() {
        var Alliance = DriverStation.getAlliance();
        if ( Alliance.isPresent() ) { return Alliance.get() == DriverStation.Alliance.Red ? "Red" : "Blue"; }
        return "Red";
    }

    public static boolean isRed  () { return GetAlliance() == "Red"  ? true : false; }
    public static boolean isBlue () { return GetAlliance() == "Blue" ? true : false; } 

//
// GAME MESSAGE STRING
//
    public static String GetStation() {
        return DriverStation.getGameSpecificMessage();
    }

//
// 
//

}
