/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.subsystems.DrivetrainSubsystem;

import static frc.robot.Constants.ControlPorts.*;


public class RobotContainer {

  //Subsystem Imports
  DrivetrainSubsystem m_driveTrainSubsystem = DrivetrainSubsystem.getInstance();

  //Command Imports
  ArcadeDriveCommand m_arcadeDriveCommand = new ArcadeDriveCommand(m_driveTrainSubsystem);

  //Controllers and Sensors
  Joystick xboxController = new Joystick(controllerPort);
  Joystick moveFlightStick = new Joystick (moveJoystickPort);
  Joystick rotateFlightStick = new Joystick(rotateJoystickPort);


  public RobotContainer() {
    //default commands
    m_driveTrainSubsystem.setDefaultCommand(m_arcadeDriveCommand);

    configureButtonBindings();
  }

  private void configureButtonBindings() {
  }


  /*
    Use this to pass the autonomous command to the main {@link Robot} class.

    @return the command to run in autonomous
   */
  /*public Command getAutonomousCommand() {
    An ExampleCommand will run in autonomous

 }*/
}
