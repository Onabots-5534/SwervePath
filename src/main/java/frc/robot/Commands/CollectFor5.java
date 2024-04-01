package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Subsystems.SubIntake;

public class CollectFor5 extends SequentialCommandGroup {

  public CollectFor5() {
    addCommands(
      new SubIntake().cSuck(),
      new Collection_On(),
      new WaitCommand( 5 ),
      new Collection_Off()
    );
  }
}
