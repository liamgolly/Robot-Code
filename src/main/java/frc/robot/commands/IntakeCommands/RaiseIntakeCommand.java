package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;


public class RaiseIntakeCommand extends CommandBase {
    private final IntakeSubsystem intakeSubsystem = IntakeSubsystem.getInstance();
    DigitalInput upperlimit;

    public RaiseIntakeCommand(DigitalInput upperLimit) {
        upperlimit = upperLimit;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        intakeSubsystem.raiseIntake();
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return !upperlimit.get();
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.disableIntake();
    }
}
