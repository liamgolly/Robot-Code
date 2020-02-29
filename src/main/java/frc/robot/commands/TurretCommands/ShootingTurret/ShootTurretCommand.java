package frc.robot.commands.TurretCommands.ShootingTurret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootTurretCommand extends CommandBase {
    private final ShooterSubsystem shooterSubsystem = ShooterSubsystem.getInstance();

    public ShootTurretCommand() { addRequirements(shooterSubsystem); }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        shooterSubsystem.Shoot();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.stopShooter();
    }
}
