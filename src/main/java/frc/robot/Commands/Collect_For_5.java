package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class Collect_For_5 extends SequentialCommandGroup {

  public Collect_For_5() {
    addCommands(

      new Collection_On(),

      new WaitCommand( 5 ),

      new Collection_Off()
  
    );
  }
}
