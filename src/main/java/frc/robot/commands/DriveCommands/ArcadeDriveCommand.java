package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

import static frc.robot.Constants.robotMovementConstants.*;


public class ArcadeDriveCommand extends CommandBase {
    private final DrivetrainSubsystem drivetrainSubsystem;

    Joystick m_xboxController;
    Joystick m_moveStick;
    Joystick m_rotateStick;


    public ArcadeDriveCommand(DrivetrainSubsystem drivetrainSubsystem, Joystick XboxController, Joystick MoveStick, Joystick RotateStick) {
        m_xboxController = XboxController;
        m_moveStick = MoveStick;
        m_rotateStick = RotateStick;

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
                if (m_xboxController.getRawAxis(xboxBrakeAxis) < m_xboxController.getRawAxis(xboxAccelerateAxis)) { drivetrainSubsystem.arcadeDrive(m_xboxController.getRawAxis(xboxAccelerateAxis)-m_xboxController.getRawAxis(xboxBrakeAxis) , m_xboxController.getRawAxis(xboxRotateAxis)); }
                else { drivetrainSubsystem.arcadeDrive(m_xboxController.getRawAxis(xboxAccelerateAxis)-m_xboxController.getRawAxis(xboxBrakeAxis) , -m_xboxController.getRawAxis(xboxRotateAxis)); }
                break;
            case 2:
                drivetrainSubsystem.arcadeDrive(m_moveStick.getX(), m_rotateStick.getZ());
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
