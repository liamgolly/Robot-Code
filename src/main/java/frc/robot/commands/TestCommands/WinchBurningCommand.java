package frc.robot.commands.TestCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TestSubsystems.WinchBurningSubsystem;

public class WinchBurningCommand extends CommandBase {
    private final WinchBurningSubsystem winchBurningSubsystem;

    int Counter;
    Boolean finished;

    public WinchBurningCommand(WinchBurningSubsystem winchBurningSubsystem) {
        this.winchBurningSubsystem = winchBurningSubsystem;
        addRequirements(winchBurningSubsystem);
    }

    @Override
    public void initialize() {
        // winchBurningSubsystem.reset();
        Counter = 0;
        finished = false;
    }

    @Override
    public void execute() {
        if (Counter < 501) {
            // System.out.println(Counter);
            winchBurningSubsystem.burn(Counter);
            if (WinchBurningSubsystem.done) {
                Counter++;
            }
        } else {
            finished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    @Override
    public void end(boolean interrupted) {}
}
