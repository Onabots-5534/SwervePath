package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class s_Collect_For_5 extends SequentialCommandGroup {

  public s_Collect_For_5() {
    addCommands(

      new i_Collection_On(),

      new WaitCommand( 5 ),

      new i_Collection_Off()
  
    );
  }
}
