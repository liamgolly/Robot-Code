package frc.robot.commands.ClimbCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;


public class RetractPVCCommand extends CommandBase {
    private final ClimbSubsystem climbSubsystem = ClimbSubsystem.getInstance();

    public RetractPVCCommand() { addRequirements(climbSubsystem); }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        climbSubsystem.lowerPVC();
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return climbSubsystem.pvcDone;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
