package frc.robot.commands.TurretCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretRotatorSubsystem;


public class StopTurretCommand extends CommandBase {
    private final TurretRotatorSubsystem turretRotatorSubsystem;

    public StopTurretCommand(TurretRotatorSubsystem turretRotatorSubsystem) {
        this.turretRotatorSubsystem = turretRotatorSubsystem;
        addRequirements(turretRotatorSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        turretRotatorSubsystem.angleZeroed();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
