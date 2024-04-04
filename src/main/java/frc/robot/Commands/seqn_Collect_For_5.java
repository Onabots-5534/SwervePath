package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class seqn_Collect_For_5 extends SequentialCommandGroup {

  public seqn_Collect_For_5() {
    addCommands(

      new inst_Collection_On(),

      new WaitCommand( 5 ),

      new inst_Collection_Off()
  
    );
  }
}
