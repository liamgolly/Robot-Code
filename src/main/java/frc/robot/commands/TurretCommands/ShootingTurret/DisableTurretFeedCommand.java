package frc.robot.commands.TurretCommands.ShootingTurret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HopperSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TurretIntakeSubsystem;


public class DisableTurretFeedCommand extends CommandBase {
    private final HopperSubsystem hopperSubsystem;
    private final ShooterSubsystem shooterSubsystem;
    private final TurretIntakeSubsystem turretIntakeSubsystem;

    public DisableTurretFeedCommand(HopperSubsystem hopperSubsystem, ShooterSubsystem shooterSubsystem, TurretIntakeSubsystem turretIntakeSubsystem) {
        this.hopperSubsystem = hopperSubsystem;
        this.shooterSubsystem = shooterSubsystem;
        this.turretIntakeSubsystem = turretIntakeSubsystem;
        addRequirements(hopperSubsystem, shooterSubsystem, turretIntakeSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        hopperSubsystem.deactiveHopper();
        turretIntakeSubsystem.deactivateTurretIntake();
        shooterSubsystem.stopShooter();
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return true;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
