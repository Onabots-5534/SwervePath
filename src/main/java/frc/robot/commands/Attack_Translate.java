package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SubDrive;
import frc.robot.subsystems.SubIntake;
import frc.robot.subsystems.SubRoller;
import frc.robot.support.SubLED;

public class Attack_Translate extends Command {

  private SubDrive  m_Drive  = null;
  private SubIntake m_Intake = null;
  private SubRoller m_Roller = null;

  private SubLED    m_LED    = null;

  public Attack_Translate() {

    // m_Drive  = Shared.m_Drive;
    // m_Intake = Shared.m_Intake;
    // m_Roller = Shared.m_Roller;

    // m_LED    = Shared.m_LED;

    // addRequirements(
    //   m_Drive,
    //   m_Intake,
    //   m_Roller
    // );
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
    m_Roller.Forward();
    m_Intake.Suck();

    table = NetworkTableInstance.getDefault().getTable("limelight-intake");

    ErrorX = 0;
    ErrorY = 0;
    ErrorZ = 0;

    m_LED.Off();
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

    if      ( Math.abs( ErrorX ) <= 3 && Math.abs( ErrorY ) <= 6  ) { m_LED.Blue (); }
    else if ( Math.abs( ErrorX ) <= 1 && Math.abs( ErrorY ) <= 2  ) { m_LED.Green(); }
    else                                                            { m_LED.Off  (); }

    m_Drive.RobotDrive( DriveX, DriveY, 0 );
  }

  @Override public void end( boolean interrupted ) {
      m_Drive   .Stop();
      m_Intake  .Stop();
      m_Roller  .Stop();
  }

  @Override public boolean isFinished() {
    return Math.abs( ErrorY ) <= 1 ? true : false;
  }
}
