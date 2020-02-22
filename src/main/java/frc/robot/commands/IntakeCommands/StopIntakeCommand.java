package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class StopIntakeCommand extends CommandBase {
    private final IntakeSubsystem intakeSubsystem;

    public StopIntakeCommand(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        intakeSubsystem.disableIntake();
    }

    @Override
    public boolean isFinished() {
        return intakeSubsystem.atLimit;
    }

    @Override
    public void end(boolean interrupted) {}
}
