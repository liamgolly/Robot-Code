package frc.robot.commands.DriveCommands;

import static frc.robot.Constants.robotMovementConstants.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class CurvatureDriveCommand extends CommandBase {
    private final DrivetrainSubsystem drivetrainSubsystem;
    Joystick controller;
    Joystick yoke;
    Joystick pedals;

    public CurvatureDriveCommand(
            DrivetrainSubsystem drivetrainSubsystem,
            Joystick XboxController,
            Joystick YOKE,
            Joystick PEDALS) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        controller = XboxController;
        yoke = YOKE;
        pedals = PEDALS;
        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {

        drivetrainSubsystem.CurvatureDrive(
                ((pedals.getRawAxis(pedalAccelerateAxis) + 1) / 2)
                        - ((pedals.getRawAxis(pedalBrakeAxis) + 1) / 2), // pedals
                // -yoke.getRawAxis(yokePushPull),   //push/pull
                // -yoke.getRawAxis(yokeBlackLever),    //levers
                yoke.getRawAxis(yokeTurnAxis)

                // controller.getRawAxis(xboxAccelerateAxis) - controller.getRawAxis(xboxBrakeAxis),
                //        controller.getRawAxis(xboxRotateAxis));
                );
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {}
}
