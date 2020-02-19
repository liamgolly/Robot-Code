/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.DriveCommands.ArcadeDriveCommand;
import frc.robot.commands.NonHICommands.BrownoutProtectionCommand;
import frc.robot.subsystems.*;
import frc.robot.subsystems.NonHISubsystems.CurrentLimiterSubsystem;

import static frc.robot.Constants.ControlPorts.*;
import static frc.robot.Constants.SensorID.*;


public class RobotContainer {

  //Controllers and Sensors
  Joystick xboxController = new Joystick(controllerPort);
  Joystick moveFlightStick = new Joystick (moveJoystickPort);
  Joystick rotateFlightStick = new Joystick(rotateJoystickPort);

  DigitalInput hallRotator = new DigitalInput(hallSensorRotator);

  //Subsystem Imports
  ClimbSubsystem m_climbSubsystem = ClimbSubsystem.getInstance();
  ColorWheelSubsystem m_colorWheelSubsystem = ColorWheelSubsystem.getInstance();
  CurrentLimiterSubsystem m_currentLimiterSubsystem = CurrentLimiterSubsystem.getInstance();
  DrivetrainSubsystem m_driveTrainSubsystem = DrivetrainSubsystem.getInstance();
  HopperSubsystem m_hopperSubsystem = HopperSubsystem.getInstance();
  IntakeSubsystem m_intakeSubsystem = IntakeSubsystem.getInstance();
  ShooterSubsystem m_shooterSubsystem = ShooterSubsystem.getInstance();
  TurretIntakeSubsystem m_turretIntakeSubsystem = TurretIntakeSubsystem.getInstance();
  TurretRotatorSubsystem m_turretRotatorSubsystem = TurretRotatorSubsystem.getInstance();

  //Command Imports
  ArcadeDriveCommand m_arcadeDriveCommand = new ArcadeDriveCommand(m_driveTrainSubsystem, xboxController, moveFlightStick, rotateFlightStick);
  BrownoutProtectionCommand m_brownoutProtectionCommand = new BrownoutProtectionCommand(m_climbSubsystem,
                                                                                        m_colorWheelSubsystem,
                                                                                        m_currentLimiterSubsystem,
                                                                                        m_driveTrainSubsystem,
                                                                                        m_hopperSubsystem,
                                                                                        m_intakeSubsystem,
                                                                                        m_shooterSubsystem,
                                                                                        m_turretIntakeSubsystem,
                                                                                        m_turretRotatorSubsystem);

  public RobotContainer() {
    //default commands
    m_driveTrainSubsystem.setDefaultCommand(m_arcadeDriveCommand);
    m_currentLimiterSubsystem.setDefaultCommand(m_brownoutProtectionCommand);

    configureButtonBindings();
  }

  private void configureButtonBindings() { }

/*
    Use this to pass the autonomous command to the main {@link Robot} class.
    @return the command to run in autonomous
    public Command getAutonomousCommand() {}
*/
}
