package frc.robot.commands.DriveCommands;

import static frc.robot.Constants.robotMovementConstants.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class CurvatureDriveCommand extends CommandBase {
    private final DrivetrainSubsystem drivetrainSubsystem;
    Joystick controller;

    public CurvatureDriveCommand(DrivetrainSubsystem drivetrainSubsystem, Joystick XboxController) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        controller = XboxController;
        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        drivetrainSubsystem.CurvatureDrive(
                controller.getRawAxis(xboxAccelerateAxis) - controller.getRawAxis(xboxBrakeAxis),
                controller.getRawAxis(xboxRotateAxis));
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {}
}
