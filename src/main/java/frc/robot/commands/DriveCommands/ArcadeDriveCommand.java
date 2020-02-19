package frc.robot.commands.DriveCommands;

import static frc.robot.Constants.robotMovementConstants.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class ArcadeDriveCommand extends CommandBase {
    private final DrivetrainSubsystem drivetrainSubsystem;

    Joystick m_xboxController;
    Joystick m_moveStick;
    Joystick m_rotateStick;

    public ArcadeDriveCommand(
            DrivetrainSubsystem drivetrainSubsystem,
            Joystick XboxController,
            Joystick MoveStick,
            Joystick RotateStick) {
        m_xboxController = XboxController;
        m_moveStick = MoveStick;
        m_rotateStick = RotateStick;

        this.drivetrainSubsystem = drivetrainSubsystem;
        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {

        switch (DrivetrainSubsystem.drivemode) {
            case 1:
                if (m_xboxController.getRawAxis(xboxBrakeAxis)
                        <= m_xboxController.getRawAxis(xboxAccelerateAxis)) {
                    drivetrainSubsystem.ArcadeDrive(
                            m_xboxController.getRawAxis(xboxAccelerateAxis)
                                    - m_xboxController.getRawAxis(xboxBrakeAxis),
                            m_xboxController.getRawAxis(xboxRotateAxis) * .9);
                } else {
                    drivetrainSubsystem.ArcadeDrive(
                            m_xboxController.getRawAxis(xboxAccelerateAxis)
                                    - m_xboxController.getRawAxis(xboxBrakeAxis),
                            -(m_xboxController.getRawAxis(xboxRotateAxis) * .9));
                }
                break;
            case 2:
                drivetrainSubsystem.ArcadeDrive(
                        m_moveStick.getRawAxis(flightStickMoveAxis),
                        m_rotateStick.getRawAxis(flightStickRotateAxis));
        }
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {}
}
