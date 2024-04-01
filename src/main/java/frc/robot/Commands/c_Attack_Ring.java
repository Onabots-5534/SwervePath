package frc.robot.Commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class c_Attack_Ring extends Command {

  public double
    TargetX = 0,
    TargetY = 2;

  public c_Attack_Ring() {
    addRequirements(
      // RobotContainer.m_CamIntake,
      RobotContainer.m_Drive,
      RobotContainer.m_Intake,
      RobotContainer.m_Roller
    );
  }

  NetworkTable      table;
  NetworkTableEntry tx;

  @Override public void initialize() {
    RobotContainer.m_Roller.Forward();
    RobotContainer.m_Intake.Suck();

    table = NetworkTableInstance.getDefault().getTable("limelight-intake");
    tx = table.getEntry("tx");
  }

  double max = 0.08;

  double
    ErrorX = 0,
    ErrorY = 0,
    ErrorZ = 0;


  @Override public void execute() {
    double RingX = table.getEntry("tx").getDouble( 0 );
    double RingY = table.getEntry("ty").getDouble( 0 );
  
    ErrorX = ( TargetX - RingX );
    ErrorY = ( TargetY - RingY );

    // NOTICE THAT THESE ARE INTENTIALLY FLIPPED
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

    RobotContainer.m_Drive.RobotDrive( DriveX, 0, DriveZ );
  }

  @Override public void end( boolean interrupted ) {
      RobotContainer.m_Drive   .Stop();
      RobotContainer.m_Intake  .Stop();
      RobotContainer.m_Roller  .Stop();
  }

  @Override public boolean isFinished() {
    if ( Math.abs( ErrorY ) <= 1 ) { return true; }
    return false;
  }
}
