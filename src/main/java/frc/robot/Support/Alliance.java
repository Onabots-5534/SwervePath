package frc.robot.Support;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

public class Alliance {

    public static GenericEntry Color = Shuffleboard.getTab( "Comp" )
        .add( "Alliance", "" )
        .withPosition( 5, 4 )
        .withSize( 2, 1 )
        .getEntry();

//
// ALLIANCE COLOR
//
    public static String GetAlliance() {
        var Alliance = DriverStation.getAlliance();
        if ( Alliance.isPresent() ) { return Alliance.get() == DriverStation.Alliance.Red ? "Red" : "Blue"; }
        return "Blue";
    }

    public static boolean isRed  () { return GetAlliance() == "Red"  ? true : false; }
    public static boolean isBlue () { return GetAlliance() == "Blue" ? true : false; } 

    public static void Initialize() {}

    public static void Periodic() {
        Color.setString( GetAlliance() );
    }

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
