package frc.robot.commands.TurretCommands.AimingTurret;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.TurretRotatorSubsystem;

public class ZeroAndAimCommandGroup extends SequentialCommandGroup {

    public ZeroAndAimCommandGroup(DigitalInput LimitSwitch) {
        super(new ZeroTurretCommand(LimitSwitch), new AimTurretCommand()); }
}
