/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import static frc.robot.Constants.ControlPorts.*;
import static frc.robot.Constants.SensorID.*;
import static frc.robot.Constants.intakeConstants.*;
import static frc.robot.Constants.robotMovementConstants.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveCommands.ArcadeDriveCommand;
import frc.robot.commands.DriveCommands.SwitchDriveModeCommand;
import frc.robot.commands.IntakeCommands.SpinIntakeCommand;
import frc.robot.commands.NonOICommands.BrownoutProtectionCommand;
import frc.robot.subsystems.*;
import frc.robot.subsystems.NonOISubsystems.CurrentLimiterSubsystem;

public class RobotContainer {

    // Controllers and Sensors
    Joystick xboxController = new Joystick(controllerPort);
    Joystick moveFlightStick = new Joystick(moveJoystickPort);
    Joystick rotateFlightStick = new Joystick(rotateJoystickPort);

    DigitalInput hallRotator = new DigitalInput(hallSensorRotator);

    // Subsystem Imports
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
  BrownoutProtectionCommand m_brownoutProtectionCommand = new BrownoutProtectionCommand( m_currentLimiterSubsystem );
 
  SpinIntakeCommand m_spinIntakeCommand = new SpinIntakeCommand(m_intakeSubsystem);
  SwitchDriveModeCommand m_switchDriveModeCommand = new SwitchDriveModeCommand(m_driveTrainSubsystem);

    SpinIntakeCommand m_spinIntakeCommand = new SpinIntakeCommand(m_intakeSubsystem);
    SwitchDriveModeCommand m_switchDriveModeCommand =
            new SwitchDriveModeCommand(m_driveTrainSubsystem);

    // Buttons
    JoystickButton activateIntakeButton =
            new JoystickButton(xboxController, activateIntakeButtonID);
    JoystickButton changeDriveModeButton =
            new JoystickButton(xboxController, changeDriveModeButtonID);

    public RobotContainer() {

        configureButtonBindings();
    }

    private void configureButtonBindings() {

        // Default Commands
        // CurrentLimiterSubsystem.getInstance().setDefaultCommand(m_brownoutProtectionCommand);
        // //how the hell do we do this?
        DrivetrainSubsystem.getInstance()
                .setDefaultCommand(
                        new ArcadeDriveCommand(
                                m_driveTrainSubsystem,
                                xboxController,
                                moveFlightStick,
                                rotateFlightStick));

        // Held Buttons
        activateIntakeButton.whileHeld(m_spinIntakeCommand, false);

        // Pressed Buttons
        changeDriveModeButton.whenPressed(m_switchDriveModeCommand);
    }

    /*
        Use this to pass the autonomous command to the main {@link Robot} class.
        @return the command to run in autonomous
        public Command getAutonomousCommand() {}
    */
}
