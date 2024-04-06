package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Shared;
import frc.robot.mode.Teleoperate;
import frc.robot.subsystems.SubDrive;

public class SplitStick extends Command {

  private SubDrive m_Drive = null;

  public SplitStick() {

    m_Drive = Shared.m_Drive;

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
