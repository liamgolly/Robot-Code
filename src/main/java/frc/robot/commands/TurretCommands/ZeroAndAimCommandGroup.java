package frc.robot.commands.TurretCommands;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.TurretRotatorSubsystem;

public class ZeroAndAimCommandGroup extends SequentialCommandGroup {

    public ZeroAndAimCommandGroup(TurretRotatorSubsystem turretRotatorSubsystem, DigitalInput LimitSwitch) {

        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new FooCommand(), new BarCommand());
        super(new ZeroTurretCommand(turretRotatorSubsystem, LimitSwitch), new AimTurretCommand(turretRotatorSubsystem));
    }
}