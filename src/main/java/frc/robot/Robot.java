package frc.robot;

import org.littletonrobotics.junction.LoggedRobot;

import frc.robot.mode.*;

public class Robot extends LoggedRobot {

  public static RobotContainer m_Container = new RobotContainer();

  @Override public void robotInit          () { Onabot        .Initialize  (); }
  @Override public void robotPeriodic      () { Onabot        .Periodic    (); }

  @Override public void disabledInit       () { Disabled      .Initialize  (); }
  @Override public void disabledPeriodic   () { Disabled      .Periodic    (); }

  @Override public void autonomousInit     () { Autonomous    .Initialize  (); }
  @Override public void autonomousPeriodic () { Autonomous    .Periodic    (); }

  @Override public void teleopInit         () { Teleoperate   .Initialize  (); }
  @Override public void teleopPeriodic     () { Teleoperate   .Periodic    (); }

  @Override public void testInit           () { Test          .Initialize  (); }
  @Override public void testPeriodic       () { Test          .Periodic    (); }

  @Override public void simulationInit     () { Simulation    .Initialize  (); }
  @Override public void simulationPeriodic () { Simulation    .Periodic    (); }
}
