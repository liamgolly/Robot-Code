package frc.robot.commands.TurretCommands.AimingTurret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretRotatorSubsystem;

public class AimTurretCommand extends CommandBase {

    TurretRotatorSubsystem turretrotatorsubsystem;

    public AimTurretCommand(TurretRotatorSubsystem turretRotatorSubsystem) {
        turretrotatorsubsystem = turretRotatorSubsystem;

        this.addRequirements(turretRotatorSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        turretrotatorsubsystem.aimTurret();
    }

    @Override
    public boolean isFinished() {
        return turretrotatorsubsystem.Aimed;
    }

    @Override
    public void end(boolean interrupted) {}
}