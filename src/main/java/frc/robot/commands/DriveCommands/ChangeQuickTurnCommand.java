package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;




public class ChangeQuickTurnCommand extends CommandBase {
    private final DrivetrainSubsystem drivetrainSubsystem;
    Joystick controller;
    private boolean done;

    public ChangeQuickTurnCommand(DrivetrainSubsystem drivetrainSubsystem) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        drivetrainSubsystem.quickTurn();
        done = true;
    }

    @Override
    public boolean isFinished() {
       if (done) {
           done = false;
           return true;
       }
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
