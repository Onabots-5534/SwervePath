package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.Subsystems.SubDrive;
import frc.robot.mode.Teleoperate;

public class SplitStick extends Command {

  private SubDrive m_Drive;

  public SplitStick() {

    m_Drive = RobotContainer.m_Drive;

    addRequirements( m_Drive );
  }

  @Override public void execute() {

    double
      X = Teleoperate.X,
      Y = Teleoperate.Y,
      Z = Teleoperate.Z;

    m_Drive.RobotDrive( X, Y, Z );
  }

}
