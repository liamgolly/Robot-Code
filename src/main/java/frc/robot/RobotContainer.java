/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import static frc.robot.Constants.ButtonID.*;
import static frc.robot.Constants.ControlPorts.*;
import static frc.robot.Constants.SensorID.*;
import static frc.robot.Constants.robotMovementConstants.*;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.classes.Limelight;
import frc.robot.commands.ClimbCommands.AutoClimbCommand;
import frc.robot.commands.ClimbCommands.ExtendPVCCommand;
import frc.robot.commands.ClimbCommands.ManualClimbCommand;
import frc.robot.commands.ClimbCommands.RetractPVCCommand;
import frc.robot.commands.DriveCommands.ArcadeDriveCommand;
import frc.robot.commands.IntakeCommands.LowerIntakeCommand;
import frc.robot.commands.IntakeCommands.RaiseIntakeCommand;
import frc.robot.commands.IntakeCommands.SpinIntakeCommand;
import frc.robot.commands.IntakeCommands.StopIntakeCommand;
import frc.robot.commands.NonOICommands.BrownoutProtectionCommand;
import frc.robot.commands.NonOICommands.LedControlCommand;
import frc.robot.commands.TurretCommands.AimingTurret.AimTurretCommand;
import frc.robot.commands.TurretCommands.AimingTurret.ZeroAndAimCommandGroup;
import frc.robot.commands.TurretCommands.AimingTurret.ZeroTurretCommand;
import frc.robot.commands.TurretCommands.ShootingTurret.DisableTurretFeedCommand;
import frc.robot.commands.TurretCommands.ShootingTurret.HopperCommand;
import frc.robot.commands.TurretCommands.ShootingTurret.ShootingCommandGroup;
import frc.robot.commands.TurretCommands.ShootingTurret.TurretIntakeCommand;
import frc.robot.subsystems.*;
import frc.robot.subsystems.NonOISubsystems.CurrentLimiterSubsystem;
import frc.robot.subsystems.NonOISubsystems.LedControlSubsystem;
import frc.robot.subsystems.TestSubsystems.NavXOutputSubsystem;

import javax.naming.LinkLoopException;

public class RobotContainer {

    // Controllers and Sensors
    Joystick xboxController = new Joystick(controllerPort);
    Joystick mainFlightStick = new Joystick(moveJoystickPort);
    Joystick altFlightStick = new Joystick(rotateJoystickPort);

    Joystick Yoke = new Joystick(yokeAxis);
    Joystick Pedals = new Joystick(pedalAxis);

    DigitalInput hallTurretRotator = new DigitalInput(hallSensorTurretRotator);
    DigitalInput intakeUpperLimit = new DigitalInput(hallSensorUpperIntakeRotator);
    DigitalInput intakeLowerLimit = new DigitalInput(hallSensorLowerIntakeRotator);

    AHRS NavX = new AHRS(SerialPort.Port.kUSB);
    Limelight limelight = new Limelight();

    // Subsystem Imports
    DrivetrainSubsystem m_drivetrainSubsystem = DrivetrainSubsystem.getInstance();
    LedControlSubsystem m_ledControlSubsystem = LedControlSubsystem.getInstance();

    // Buttons
    JoystickButton LowerIntakeButton = new JoystickButton(mainFlightStick, LowerIntakeID);
    JoystickButton aimTurret = new JoystickButton(mainFlightStick, autoAimID);
    JoystickButton ShootButton = new JoystickButton(mainFlightStick, ShootID);
    JoystickButton OverrideClimbMode = new JoystickButton(mainFlightStick, OverrideClimbModeID);
    JoystickButton EnableTriangle = new JoystickButton(mainFlightStick, EnableTriangleID);
    JoystickButton EnableLift = new JoystickButton(mainFlightStick, EnableLiftID);
    JoystickButton LowerPVC = new JoystickButton(mainFlightStick, LowerPVCID);
    JoystickButton RaisePVC = new JoystickButton(mainFlightStick, RaisePVCID);
    JoystickButton RaiseIntake = new JoystickButton(mainFlightStick, RaiseIntakeID);
    JoystickButton OverrideIntake = new JoystickButton(mainFlightStick, OverrideIntakeID);
    JoystickButton AutoClimb = new JoystickButton(mainFlightStick, AutoClimbID);
    JoystickButton LimelightAim = new JoystickButton(mainFlightStick, LimelightAimID);

    JoystickButton StageOneColorWheel = new JoystickButton(altFlightStick, ColorWheelStageOneID);
    JoystickButton StageTwoColorWheel = new JoystickButton(altFlightStick, ColorWheelStageTwoID);


    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        // Default Commands

//      CurrentLimiterSubsystem.getInstance().setDefaultCommand(m_brownoutProtectionCommand);
        m_drivetrainSubsystem.setDefaultCommand(new ArcadeDriveCommand(xboxController, mainFlightStick, altFlightStick, NavX));
        m_ledControlSubsystem.setDefaultCommand(new LedControlCommand());

        // Held Buttons
        ShootButton.whileHeld(new ShootingCommandGroup(), true);
        EnableTriangle.whileHeld(new HopperCommand());
        EnableLift.whileHeld(new TurretIntakeCommand());
        AutoClimb.whileHeld(new AutoClimbCommand(NavX));
        OverrideClimbMode.whileHeld(new ManualClimbCommand(mainFlightStick, altFlightStick));

        // Pressed Buttons
        aimTurret.whenPressed(new ZeroAndAimCommandGroup(hallTurretRotator));
        LowerIntakeButton.whenPressed(new LowerIntakeCommand(intakeLowerLimit));
        RaiseIntake.whenPressed(new RaiseIntakeCommand(intakeUpperLimit));
        OverrideIntake.whenPressed(new DisableTurretFeedCommand());
        RaisePVC.whenPressed(new ExtendPVCCommand());
        LowerPVC.whenPressed(new RetractPVCCommand());

        // Sensor Activations
    }

    /*
        Use this to pass the autonomous command to the main {@link Robot} class.
        @return the command to run in autonomous
        public Command getAutonomousCommand() {}
    */
}
