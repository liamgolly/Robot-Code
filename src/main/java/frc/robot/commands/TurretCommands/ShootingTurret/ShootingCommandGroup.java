package frc.robot.commands.TurretCommands.ShootingTurret;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.HopperSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TurretIntakeSubsystem;

public class ShootingCommandGroup extends ParallelCommandGroup {
    public ShootingCommandGroup(
            HopperSubsystem hopperSubsystem,
            ShooterSubsystem shooterSubsystem,
            TurretIntakeSubsystem turretIntakeSubsystem) {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new FooCommand(), new BarCommand());
        super(
                new HopperCommand(hopperSubsystem),
                new ShootTurretCommand(shooterSubsystem),
                new TurretIntakeCommand(turretIntakeSubsystem));
    }
}
