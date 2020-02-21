/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import static frc.robot.Constants.ControlPorts.*;
import static frc.robot.Constants.SensorID.*;
import static frc.robot.Constants.ShooterConstants.*;
import static frc.robot.Constants.intakeConstants.*;
import static frc.robot.Constants.robotMovementConstants.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveCommands.ArcadeDriveCommand;
import frc.robot.commands.DriveCommands.ChangeQuickTurnCommand;
import frc.robot.commands.DriveCommands.CurvatureDriveCommand;
import frc.robot.commands.DriveCommands.SwitchDriveModeCommand;
import frc.robot.commands.IntakeCommands.SpinIntakeCommand;
import frc.robot.commands.IntakeCommands.StopIntakeCommand;
import frc.robot.commands.NonOICommands.BrownoutProtectionCommand;
import frc.robot.commands.TurretCommands.ShootTurretCommand;
import frc.robot.commands.TurretCommands.StopTurretCommand;
import frc.robot.subsystems.*;
import frc.robot.subsystems.NonOISubsystems.CurrentLimiterSubsystem;

public class RobotContainer {

    // Controllers and Sensors
    Joystick xboxController = new Joystick(controllerPort);
    Joystick moveFlightStick = new Joystick(moveJoystickPort);
    Joystick rotateFlightStick = new Joystick(rotateJoystickPort);

    DigitalInput hallTurretRotator = new DigitalInput(hallSensorTurretRotator);
    DigitalInput intakeTurretLimit = new DigitalInput(hallSensorIntakeRotator);

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

    // Command Imports
    BrownoutProtectionCommand m_brownoutProtectionCommand =
            new BrownoutProtectionCommand(m_currentLimiterSubsystem);

    SpinIntakeCommand m_spinIntakeCommand = new SpinIntakeCommand(m_intakeSubsystem);
    SwitchDriveModeCommand m_switchDriveModeCommand =
            new SwitchDriveModeCommand(m_driveTrainSubsystem);
    ShootTurretCommand m_shootTurretCommand =
            new ShootTurretCommand((m_shooterSubsystem));
    StopIntakeCommand m_stopIntakeCommand = new StopIntakeCommand(m_intakeSubsystem);
    StopTurretCommand m_stopTurretCommand = new StopTurretCommand(m_turretRotatorSubsystem);

    // Buttons
    JoystickButton activateIntakeButton =
            new JoystickButton(xboxController, activateIntakeButtonID);
    JoystickButton changeDriveModeButton =
            new JoystickButton(xboxController, changeDriveModeButtonID);
    JoystickButton ShootButton =
            new JoystickButton(xboxController, shootButtonID);
    JoystickButton quickTurn = new JoystickButton(xboxController, 5);

    Button intakeLimitSwitch = new Button(() -> intakeTurretLimit.get());
    Button turretRotatorSensor = new Button(() -> hallTurretRotator.get());


    public RobotContainer() {

        configureButtonBindings();
    }

    private void configureButtonBindings() {

        // Default Commands
        CurrentLimiterSubsystem.getInstance().setDefaultCommand(m_brownoutProtectionCommand);
//        DrivetrainSubsystem.getInstance()
//                .setDefaultCommand(
//                        new ArcadeDriveCommand(
//                                m_driveTrainSubsystem,
//                                xboxController,
//                                moveFlightStick,
//                                rotateFlightStick));
        DrivetrainSubsystem.getInstance()
                .setDefaultCommand(
                        new CurvatureDriveCommand(
                                m_driveTrainSubsystem,
                                xboxController
                        )
                );


        // Held Buttons
        activateIntakeButton.whileHeld(m_spinIntakeCommand, false);
        ShootButton.whileHeld(m_shootTurretCommand, false);


        // Pressed Buttons
        changeDriveModeButton.whenPressed(m_switchDriveModeCommand);
        quickTurn.whenPressed(new ChangeQuickTurnCommand(m_driveTrainSubsystem));



        // Sensor Activations
        intakeLimitSwitch.whenPressed(m_stopIntakeCommand);
        turretRotatorSensor.whenPressed(m_stopTurretCommand);
    }

    /*
        Use this to pass the autonomous command to the main {@link Robot} class.
        @return the command to run in autonomous
        public Command getAutonomousCommand() {}
    */
}
