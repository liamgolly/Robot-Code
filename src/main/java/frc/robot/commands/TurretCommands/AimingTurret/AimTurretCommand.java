package frc.robot.commands.TurretCommands.AimingTurret;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.classes.Limelight;
import frc.robot.subsystems.TurretRotatorSubsystem;

import static frc.robot.Constants.ShooterConstants.shooterClamp;
import static frc.robot.Constants.TurretRotatorConstants.*;

public class AimTurretCommand extends CommandBase {
    public double previous_error;
    public double integral;
    public double derivative;

    private double motorpower = 0;

    private Timer aimTimer = new Timer();
    public boolean targetInSight = false;

    Limelight limelight = new Limelight();

    TurretRotatorSubsystem turretrotatorsubsystem = TurretRotatorSubsystem.getInstance();

    public AimTurretCommand() {
        this.addRequirements(turretrotatorsubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        double error = limelight.getTx();
        integral += error * 0.02;
        derivative = (error - previous_error) / 0.02;

        if (error > 1.0) {
            motorpower = (turretRotatorP * error) + (turretRotatorI * integral) + (turretRotatorD * derivative);
        } else if (error < 1.0) {
            motorpower = -1 * ((turretRotatorP * error) + (turretRotatorI * integral) + (turretRotatorD * derivative));
        } else {
            motorpower = 0;
        }

        motorpower = Math.max(-shooterClamp, Math.min(shooterClamp, motorpower));

        turretrotatorsubsystem.turnTurretPower(motorpower);

        previous_error = error;

        if (error < 3) {
            if (aimTimer.get() == 0) {
                aimTimer.start();
            }

            if (aimTimer.get() > 1) {
                targetInSight = true;
            }
        }
        if (error > 3) {
            aimTimer.reset();
        }
    }

    @Override
    public boolean isFinished() {
        return targetInSight;
    }

    @Override
    public void end(boolean interrupted) {
    }
}
