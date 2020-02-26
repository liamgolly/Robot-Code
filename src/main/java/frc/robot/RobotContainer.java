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

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveCommands.ArcadeDriveCommand;
import frc.robot.commands.DriveCommands.ChangeQuickTurnCommand;
import frc.robot.commands.DriveCommands.CurvatureDriveCommand;
import frc.robot.commands.IntakeCommands.SpinIntakeCommand;
import frc.robot.commands.IntakeCommands.StopIntakeCommand;
import frc.robot.commands.NonOICommands.BrownoutProtectionCommand;
import frc.robot.commands.TestCommands.NavXOutputCommand;
import frc.robot.commands.TurretCommands.AimingTurret.ZeroAndAimCommandGroup;
import frc.robot.commands.TurretCommands.ShootingTurret.ShootingCommandGroup;
import frc.robot.subsystems.*;
import frc.robot.subsystems.NonOISubsystems.CurrentLimiterSubsystem;
import frc.robot.subsystems.TestSubsystems.NavXOutputSubsystem;

public class RobotContainer {

    // Controllers and Sensors
    Joystick xboxController = new Joystick(controllerPort);
    Joystick moveFlightStick = new Joystick(moveJoystickPort);
    Joystick rotateFlightStick = new Joystick(rotateJoystickPort);

    Joystick Yoke = new Joystick(yokeAxis);
    Joystick Pedals = new Joystick(pedalAxis);

    DigitalInput hallTurretRotator = new DigitalInput(hallSensorTurretRotator);
    DigitalInput intakeUpperLimit = new DigitalInput(hallSensorUpperIntakeRotator);
    DigitalInput intakeLowerLimit = new DigitalInput(hallSensorLowerIntakeRotator);

    AHRS NavX = new AHRS(SerialPort.Port.kUSB);

    // Subsystem Imports
    ClimbSubsystem m_climbSubsystem = ClimbSubsystem.getInstance();
    CurrentLimiterSubsystem m_currentLimiterSubsystem = CurrentLimiterSubsystem.getInstance();
    DrivetrainSubsystem m_driveTrainSubsystem = DrivetrainSubsystem.getInstance();
    HopperSubsystem m_hopperSubsystem = HopperSubsystem.getInstance();
    IntakeSubsystem m_intakeSubsystem = IntakeSubsystem.getInstance();
    NavXOutputSubsystem m_NavXOutputSubsystem = NavXOutputSubsystem.getInstance();
    ShooterSubsystem m_shooterSubsystem = ShooterSubsystem.getInstance();
    TurretIntakeSubsystem m_turretIntakeSubsystem = TurretIntakeSubsystem.getInstance();
    TurretRotatorSubsystem m_turretRotatorSubsystem = TurretRotatorSubsystem.getInstance();


    // Command Imports
    BrownoutProtectionCommand m_brownoutProtectionCommand =
            new BrownoutProtectionCommand(m_currentLimiterSubsystem);
    SpinIntakeCommand m_spinIntakeCommand = new SpinIntakeCommand(m_intakeSubsystem);
    StopIntakeCommand m_stopIntakeCommand = new StopIntakeCommand(m_intakeSubsystem);

    // Command Groups
    ZeroAndAimCommandGroup m_zeroAndAimCommandGroup =
            new ZeroAndAimCommandGroup(m_turretRotatorSubsystem, hallTurretRotator);
    ShootingCommandGroup m_shootingCommandGroup =
            new ShootingCommandGroup(
                    m_hopperSubsystem, m_shooterSubsystem, m_turretIntakeSubsystem);

    // Buttons
    JoystickButton activateIntakeButton =
            new JoystickButton(xboxController, activateIntakeButtonID);
    JoystickButton ShootButton = new JoystickButton(xboxController, shootButtonID);
    JoystickButton quickTurn = new JoystickButton(Yoke, quickTurnButtonID);
    JoystickButton aimTurret = new JoystickButton(xboxController, aimButtonID);

    Button intakeLowerLimitSwitch = new Button(() -> intakeLowerLimit.get());
    Button intakeUpperLimitSwitch = new Button(() -> intakeUpperLimit.get());

    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {


        // Default Commands

        // CurrentLimiterSubsystem.getInstance().setDefaultCommand(m_brownoutProtectionCommand);
        DrivetrainSubsystem.getInstance()
                .setDefaultCommand(
                        new ArcadeDriveCommand(
                                m_driveTrainSubsystem,
                                xboxController,
                                moveFlightStick,
                                rotateFlightStick,
                                Yoke,
                                Pedals,
                                NavX));

        //NavXOutputSubsystem.getInstance().setDefaultCommand(new NavXOutputCommand(m_NavXOutputSubsystem, NavX));


        // Held Buttons
        activateIntakeButton.whileHeld(m_spinIntakeCommand, false);
        ShootButton.whileHeld(m_shootingCommandGroup, false);

        // Pressed Buttons
        // quickTurn.whenPressed(new ChangeQuickTurnCommand(m_driveTrainSubsystem));
        aimTurret.whenPressed(m_zeroAndAimCommandGroup);
        quickTurn.whenPressed(new ChangeQuickTurnCommand(m_driveTrainSubsystem));

        // Sensor Activations
        intakeLowerLimitSwitch.whenPressed(m_stopIntakeCommand);
        intakeUpperLimitSwitch.whenPressed(m_stopIntakeCommand);
    }

    /*
        Use this to pass the autonomous command to the main {@link Robot} class.
        @return the command to run in autonomous
        public Command getAutonomousCommand() {}
    */
}
