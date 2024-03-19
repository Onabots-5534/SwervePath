package frc.robot.Subsystems;

import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SubSwerve extends SubsystemBase {

    public String
      Name = "n/a";

    public TalonFX
      Drive,
      Steer;

    public CANcoder
      Encod;

    // CLOSED LOOP VELOCITY: Start at Velocity 0, disable FOC, no feed forward, use Slot 0
    private final VelocityVoltage m_voltageVelocity = new VelocityVoltage( 0, 0, false, 0, 0, false, false, false );

    // CLOSED LOOP POSITION: Start at position 0, disable FOC, no feed forward, use slot 1
    private final PositionVoltage m_voltagePosition = new PositionVoltage( 0, 0, false, 0, 1, false, false, false );

    public SubSwerve( String name, int[] ID ) {
      Name  = name;
      Drive = new TalonFX ( ID[0] );
      Steer = new TalonFX ( ID[1] );
      Encod = new CANcoder( ID[2] );

      // NEUTRAL MODE
      Drive.setNeutralMode( NeutralModeValue.Brake );
      Steer.setNeutralMode( NeutralModeValue.Brake );

      TalonFXConfiguration configs = new TalonFXConfiguration();

        /* Voltage-based velocity requires a feed forward to account for the back-emf of the motor */
        configs.Slot0.kP = 0.11;   // An error of 1 rotation per second results in 2V output
        configs.Slot0.kI = 0.50;   // An error of 1 rotation per second increases output by 0.5V every second
        configs.Slot0.kD = 0.0001; // A change of 1 rotation per second squared results in 0.01 volts output
        configs.Slot0.kV = 0.12;   // Falcon 500 is a 500kV motor, 500rpm per V = 8.333 rps per V, 1/8.33 = 0.12 volts / Rotation per second
        
        /* Torque-based velocity does not require a feed forward, as torque will accelerate the rotor up to the desired velocity by itself */
        // configs.Slot1.kP = 5;     // An error of 1 rotation per second results in 5 amps output
        // configs.Slot1.kI = 0.1;   // An error of 1 rotation per second increases output by 0.1 amps every second
        // configs.Slot1.kD = 0.001; // A change of 1000 rotation per second squared results in 1 amp output

        // 
        configs.Slot1.kP = 2.4; // An error of 0.5 rotations results in 1.2 volts output
        configs.Slot1.kD = 0.1; // A change of 1 rotation per second results in 0.1 volts output

        // PEAK OUTPUT OF 8 VOLTS, CONSIDER MAKING THIS 10 VOLTS
        configs.Voltage.PeakForwardVoltage =  8;
        configs.Voltage.PeakReverseVoltage = -8;

        // PEAK OUTPUT OF 40 AMPS, DEFAULT FROM CTRE IS NO LIMIT
        configs.TorqueCurrent.PeakForwardTorqueCurrent =  40;
        configs.TorqueCurrent.PeakReverseTorqueCurrent = -40;

        /* Retry config apply up to 5 times, report if failure */
        StatusCode status = StatusCode.StatusCodeNotInitialized;

          for ( int i = 0; i < 5; ++i ) {
            status = Drive.getConfigurator().apply( configs );
            if ( !status.isOK() ) { System.out.println( "Could not apply Drive configs, error code: " + status.toString() ); }
            if (  status.isOK() ) break; else System.out.println( "Could not apply Drive configs, error code: " + status.toString() );
          }

          for ( int i = 0; i < 5; ++i ) {
            status = Steer.getConfigurator().apply( configs );
            if ( !status.isOK() ) System.out.println( "Could not apply Steer configs, error code: " + status.toString() );
            if (  status.isOK() ) break; else System.out.println( "Could not apply Steer configs, error code: " + status.toString() );
          }

    }

  // This is not actually needed
  @Override public void periodic() {}

//
//
//
  public void SetTargetState( SwerveModuleState state ) {
    double speed_rps = state.speedMetersPerSecond * 1; // TODO: Change 1 to conversion factor to revolutions per second
    double angle_deg = state.angle.getDegrees();

    Drive.setControl( m_voltageVelocity.withVelocity( speed_rps ) ); // Set Drive Speed: Use voltage velocity
    Steer.setControl( m_voltagePosition.withPosition( angle_deg ) ); // Set Steer Angle: Set as Closed-Loop Position
  }

  public SwerveModulePosition GetPosition() {
    return new SwerveModulePosition(
      Drive.getPosition().getValueAsDouble(),                   // Distance in meters
      new Rotation2d( Encod.getPosition().getValueAsDouble() )  // Parameter is angle in rotations, CONVERT TO RADIANS ?
    );
  }

  public SwerveModuleState GetVelocity() {
    return new SwerveModuleState(
      Drive.getVelocity().getValueAsDouble(),                   // getVelocity reports correctly as m/s 
      new Rotation2d( Encod.getPosition().getValueAsDouble() )  // getPosition = rotations, CONVERT TO RADIANS ?
    );
  }

}
