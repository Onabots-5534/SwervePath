package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class Attack_Translate extends Command {

  public Attack_Translate() {
    addRequirements(
      RobotContainer.m_Drive,
      RobotContainer.m_Intake,
      RobotContainer.m_Roller
    );
  }

  public double
    TargetX = 0,
    TargetY = 2;

  double
    ErrorX = 0,
    ErrorY = 0,
    ErrorZ = 0;

  NetworkTable
    table;

  NetworkTableEntry
    tx;

  @Override public void initialize() {
    RobotContainer.m_Roller.Forward();
    RobotContainer.m_Intake.Suck();

    table = NetworkTableInstance.getDefault().getTable("limelight-intake");

    ErrorX = 0;
    ErrorY = 0;
    ErrorZ = 0;

    RobotContainer.m_Led.Off();
  }

  double max = 0.08;

  @Override public void execute() {
    double RingX = table.getEntry("tx").getDouble( 0 );
    double RingY = table.getEntry("ty").getDouble( 0 );
  
    ErrorX = ( TargetX - RingX );
    ErrorY = ( TargetY - RingY );

    // NOTICE THAT X AND YARE INTENTIALLY FLIPPED
    // Camera Vertical is Y, Drive Forward is X
    double DriveX = ErrorY *  0.08;
    double DriveY = ErrorX * -0.08;
    double DriveZ = ErrorX *  0.04;

    if ( DriveX >  max ) { DriveX =  max; }
    if ( DriveX < -max ) { DriveX = -max; }

    if ( DriveY >  max ) { DriveY =  max; }
    if ( DriveY < -max ) { DriveY = -max; }

    if ( DriveZ >  max ) { DriveZ =  max; }
    if ( DriveZ < -max ) { DriveZ = -max; }

    if      ( Math.abs( ErrorX ) <= 3 && Math.abs( ErrorY ) <= 6  ) { RobotContainer.m_Led.Blue (); }
    else if ( Math.abs( ErrorX ) <= 1 && Math.abs( ErrorY ) <= 2  ) { RobotContainer.m_Led.Green(); }
    else                                                            { RobotContainer.m_Led.Off  (); }

    RobotContainer.m_Drive.RobotDrive( DriveX, DriveY, 0 );
  }

  @Override public void end( boolean interrupted ) {
      RobotContainer.m_Drive   .Stop();
      RobotContainer.m_Intake  .Stop();
      RobotContainer.m_Roller  .Stop();
  }

  @Override public boolean isFinished() {
    return Math.abs( ErrorY ) <= 1 ? true : false;
  }
}
