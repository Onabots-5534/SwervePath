package frc.robot.Config;

import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Config.Ports.pStick;
import frc.robot.Support.NewPose;

public class Bindings {

    // CONTROLLERS
    public static CommandPS4Controller  DS = new CommandPS4Controller ( pStick.USB_DS );
    public static CommandXboxController MS = new CommandXboxController( pStick.USB_MS );

    public static void Shuffle() {
        // Add a button to run the example auto to SmartDashboard, this will also be in the auto chooser built above
        SmartDashboard.putData( "Example Auto", new PathPlannerAuto("Example Auto") );
        SmartDashboard.putData( "Ctr-C",        new PathPlannerAuto( "Ctr-C" )      );

        // Add a button to run pathfinding commands to SmartDashboard
        SmartDashboard.putData( "Pickup Position",  NewPose.Absolute( 14.00, 6.50, 0 ) );
        SmartDashboard.putData( "Scoring Position", NewPose.Absolute(  2.15, 3.00, 0 ) );
    }

    public static void Drive() {
    }

    public static void Manip() {
    }
}
