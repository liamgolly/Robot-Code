package frc.robot.commands.TurretCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretIntakeSubsystem;


public class TurretIntakeCommand extends CommandBase {
    private final TurretIntakeSubsystem turretIntakeSubsystem;

    public TurretIntakeCommand(TurretIntakeSubsystem turretIntakeSubsystem) {
        this.turretIntakeSubsystem = turretIntakeSubsystem;
        addRequirements(turretIntakeSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

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
