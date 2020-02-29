package frc.robot.commands.TurretCommands.AimingTurret;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretRotatorSubsystem;

public class ZeroTurretCommand extends CommandBase {
    private final TurretRotatorSubsystem turretRotatorSubsystem = TurretRotatorSubsystem.getInstance();
    private final DigitalInput sensor;

    public ZeroTurretCommand (DigitalInput Sensor) {
        this.sensor = Sensor;
        addRequirements(turretRotatorSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        turretRotatorSubsystem.zeroTurret(sensor.get());
    }

    @Override
    public boolean isFinished() {
        return !sensor.get();
    }

    @Override
    public void end(boolean interrupted) {}
}
