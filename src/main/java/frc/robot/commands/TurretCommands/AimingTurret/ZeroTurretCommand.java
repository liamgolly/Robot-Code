package frc.robot.commands.TurretCommands.AimingTurret;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretRotatorSubsystem;

public class ZeroTurretCommand extends CommandBase {
    private final TurretRotatorSubsystem turretRotatorSubsystem = TurretRotatorSubsystem.getInstance();
    private final DigitalInput sensor;
    boolean isLinedUp = false;

    public ZeroTurretCommand (DigitalInput Sensor) {
        this.sensor = Sensor;
        addRequirements(turretRotatorSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        isLinedUp = sensor.get();
        if (sensor.get()) {
            turretRotatorSubsystem.turnTurretPower(0.2);
        } else {
            turretRotatorSubsystem.turnTurretPower(0.0);
            turretRotatorSubsystem.zeroTurretEncoder(isLinedUp);
        }
    }

    @Override
    public boolean isFinished() {
        return isLinedUp;
    }

    @Override
    public void end(boolean interrupted) {}
}
