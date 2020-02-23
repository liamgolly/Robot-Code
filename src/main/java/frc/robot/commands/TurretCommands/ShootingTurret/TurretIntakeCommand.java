package frc.robot.commands.TurretCommands.ShootingTurret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretIntakeSubsystem;

public class TurretIntakeCommand extends CommandBase {
    private final TurretIntakeSubsystem turretIntakeSubsystem;

    public TurretIntakeCommand(TurretIntakeSubsystem turretIntakeSubsystem) {
        this.turretIntakeSubsystem = turretIntakeSubsystem;
        addRequirements(turretIntakeSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        turretIntakeSubsystem.activateTurretIntake();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        turretIntakeSubsystem.deactivateTurretIntake();
    }
}
