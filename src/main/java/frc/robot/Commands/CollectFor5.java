package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.MechState.CollectOff;
import frc.robot.MechState.CollectOn;
import frc.robot.Subsystems.SubIntake;

public class CollectFor5 extends SequentialCommandGroup {

  public CollectFor5() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new SubIntake().cSuck(),
      new CollectOn(),
      new WaitCommand( 5 ),
      new CollectOff()
    );
  }
}
