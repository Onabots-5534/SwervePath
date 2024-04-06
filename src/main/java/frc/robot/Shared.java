package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.board.*;
import frc.robot.constants.Ports.pStick;
import frc.robot.subsystems.*;
import frc.robot.support.*;

public class Shared {

    public static CommandPS4Controller  m_DriveStick = null;
    public static CommandXboxController m_ManipStick = null;

    public static SubAimer   m_Aimer   = null;
    public static SubClimber m_Climber = null;
    public static SubDrive   m_Drive   = null;
    public static SubIntake  m_Intake  = null;
    public static SubMover   m_Mover   = null;
    public static SubRoller  m_Roller  = null;
    public static SubShooter m_Shooter = null;

    public static CameraIntake m_CameraIntake = null;
    public static SubLED m_LED = null;

    public static AimerTab       m_AimerTab       = null;
    public static AutonomousTab  m_AutonomousTab  = null;
    public static CameraTab      m_CameraTab      = null;
    public static CompetitionTab m_CompetitionTab = null;
    public static IntakeTab      m_IntakeTab      = null;
    public static MoverTab       m_MoverTab       = null;
    public static NavigationTab  m_NavigationTab  = null;
    public static RollerTab      m_RollerTab      = null;
    public static ShooterTab     m_ShooterTab     = null;

    public static void initSubsystems() {

        m_CameraTab      = new CameraTab();
        m_NavigationTab  = new NavigationTab();

        m_DriveStick = new CommandPS4Controller ( pStick.USB_DS );
        m_ManipStick = new CommandXboxController( pStick.USB_MS );

        // m_Aimer      = new SubAimer();
        // m_Climber    = new SubClimber();
        // m_Drive      = new SubDrive();
        // m_Intake     = new SubIntake();
        // m_Mover      = new SubMover();
        // m_Roller     = new SubRoller();
        // m_Shooter    = new SubShooter();

        m_CameraIntake   = new CameraIntake();
        m_CameraTarget   = new CameraTarget();

        // m_AimerTab       = new AimerTab();
        // m_AutonomousTab  = new AutonomousTab();
        // m_CompetitionTab = new CompetitionTab(); 
        m_IntakeTab      = new IntakeTab();
        // m_MoverTab       = new MoverTab();
        // m_RollerTab      = new RollerTab();
        // m_ShooterTab     = new ShooterTab();

        // m_LED        = new SubLED();
    }

    // public static SubDrive getSubDrive() {
    //     if ( m_Drive == null ) { m_Drive = new SubDrive(); }
    //     return m_Drive;
    // }

}
