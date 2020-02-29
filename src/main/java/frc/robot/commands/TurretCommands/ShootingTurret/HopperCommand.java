package frc.robot.commands.TurretCommands.ShootingTurret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HopperSubsystem;

public class HopperCommand extends CommandBase {
    private final HopperSubsystem hopperSubsystem = HopperSubsystem.getInstance();

    public HopperCommand() { addRequirements(hopperSubsystem); }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        hopperSubsystem.activateHopper();
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        hopperSubsystem.deactiveHopper();
    }
}
