package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;


public class LowerIntakeCommand extends CommandBase {
    private final IntakeSubsystem intakeSubsystem = IntakeSubsystem.getInstance();
    DigitalInput lowerlimit;

    public LowerIntakeCommand(DigitalInput lowerLimit) {
        lowerlimit = lowerLimit;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        intakeSubsystem.lowerIntake();
    }

    @Override
    public boolean isFinished() {
        return !lowerlimit.get();
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.disableIntake();
    }
}
