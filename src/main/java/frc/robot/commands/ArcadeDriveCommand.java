package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

import static frc.robot.Constants.robotMovementConstants.*;


public class ArcadeDriveCommand extends CommandBase {
    private final DrivetrainSubsystem drivetrainSubsystem;



    public ArcadeDriveCommand(DrivetrainSubsystem drivetrainSubsystem) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void initialize() {

    }


    @Override
    public void execute() {
        switch (driveMode) {
            case 1:
                if (xboxController.getRawAxis(xboxBrakeAxis) < xboxController.getRawAxis(xboxAccelerateAxis)) { drivetrainSubsystem.arcadeDrive(xboxController.getRawAxis(xboxAccelerateAxis)-xboxController.getRawAxis(xboxBrakeAxis) , xboxController.getRawAxis(xboxRotateAxis)); }
                else { drivetrainSubsystem.arcadeDrive(xboxController.getRawAxis(xboxAccelerateAxis)-xboxController.getRawAxis(xboxBrakeAxis) , -xboxController.getRawAxis(xboxRotateAxis)); }
                break;
            case 2:
                drivetrainSubsystem.arcadeDrive(moveFlightStick.getX(), rotateFlightStick.getZ());
        }

    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
