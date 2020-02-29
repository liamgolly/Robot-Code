package frc.robot.commands.TurretCommands.ShootingTurret;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.HopperSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TurretIntakeSubsystem;

public class ShootingCommandGroup extends ParallelCommandGroup {
    public ShootingCommandGroup() {
        super(new HopperCommand(), new ShootTurretCommand(), new TurretIntakeCommand()); }
}
