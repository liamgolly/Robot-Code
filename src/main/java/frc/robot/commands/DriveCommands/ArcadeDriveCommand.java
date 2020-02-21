package frc.robot.commands.DriveCommands;

import static frc.robot.Constants.robotMovementConstants.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class ArcadeDriveCommand extends CommandBase {
    private final DrivetrainSubsystem drivetrainSubsystem;

    Joystick m_wheel;
    Joystick m_pedals;

    public ArcadeDriveCommand(
            DrivetrainSubsystem drivetrainSubsystem, Joystick wheel, Joystick pedals) {
        m_wheel = wheel;
        m_pedals = pedals;

        this.drivetrainSubsystem = drivetrainSubsystem;
        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        double speed = -(((m_pedals.getRawAxis(1) + 1) / 2) - ((m_pedals.getRawAxis(0) + 1) / 2));
        drivetrainSubsystem.ArcadeDrive(speed, -m_wheel.getRawAxis(0));
        //        drivetrainSubsystem.CurvatureDrive(
        //                -speed,
        //                -m_wheel.getRawAxis(0));
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {}
}
