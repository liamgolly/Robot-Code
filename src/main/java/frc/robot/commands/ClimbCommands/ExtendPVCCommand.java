package frc.robot.commands.ClimbCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;

public class ExtendPVCCommand extends CommandBase {
    private final ClimbSubsystem climbSubsystem;

    public ExtendPVCCommand(ClimbSubsystem climbSubsystem) {
        this.climbSubsystem = climbSubsystem;
        addRequirements(climbSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        climbSubsystem.raisePVC();
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {}
}
