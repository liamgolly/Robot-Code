package frc.robot.commands.DriveCommands;

import static frc.robot.Constants.robotMovementConstants.*;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class ArcadeDriveCommand extends CommandBase {
    private final DrivetrainSubsystem drivetrainSubsystem = DrivetrainSubsystem.getInstance();

    Joystick m_xboxController;
    Joystick m_moveStick;
    Joystick m_rotateStick;
    AHRS navx;

    public ArcadeDriveCommand(
            Joystick XboxController,
            Joystick MoveStick,
            Joystick RotateStick,
            AHRS NavX) {
        m_xboxController = XboxController;
        m_moveStick = MoveStick;
        m_rotateStick = RotateStick;
        navx = NavX;

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
                    drivetrainSubsystem.ArcadeDriveStraight(
                            m_xboxController.getRawAxis(xboxAccelerateAxis)
                                    - m_xboxController.getRawAxis(xboxBrakeAxis),
                            m_xboxController.getRawAxis(xboxRotateAxis) * .9,
                            navx.getAngle());
                } else {
                    drivetrainSubsystem.ArcadeDriveStraight(
                            m_xboxController.getRawAxis(xboxAccelerateAxis)
                                    - m_xboxController.getRawAxis(xboxBrakeAxis),
                            -(m_xboxController.getRawAxis(xboxRotateAxis) * .9),
                            navx.getAngle());
                }
                break;
            case 2:
                drivetrainSubsystem.ArcadeDriveStraight(
                        -m_moveStick.getRawAxis(flightStickMoveAxis),
                        m_rotateStick.getRawAxis(flightStickRotateAxis),
                        navx.getAngle());

//            case 3:
//                drivetrainSubsystem.ArcadeDriveStraight(
//                        ((pedals.getRawAxis(pedalAccelerateAxis) + 1) / 2)
//                                - ((pedals.getRawAxis(pedalBrakeAxis) + 1) / 2),
//                        yoke.getRawAxis(yokeTurnAxis),
//                        navx.getAngle());
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
