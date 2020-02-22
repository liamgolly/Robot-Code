package frc.robot.commands.Autonomous;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.HopperSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TurretIntakeSubsystem;
import frc.robot.subsystems.TurretRotatorSubsystem;

public class AutoBeginMovement extends CommandBase {
    private final DrivetrainSubsystem drivetrainSubsystem;
    private final HopperSubsystem hopperSubsystem;
    private final IntakeSubsystem intakeSubsystem;
    private final ShooterSubsystem shooterSubsystem;
    private final TurretIntakeSubsystem turretIntakeSubsystem;
    private final TurretRotatorSubsystem turretRotatorSubsystem;
    private final AHRS navx;

    public static boolean taskCompleted = false;

    public AutoBeginMovement(
            DrivetrainSubsystem drivetrainSubsystem,
            HopperSubsystem hopperSubsystem,
            IntakeSubsystem intakeSubsystem,
            ShooterSubsystem shooterSubsystem,
            TurretIntakeSubsystem turretIntakeSubsystem,
            TurretRotatorSubsystem turretRotatorSubsystem,
            AHRS NavX) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        this.hopperSubsystem = hopperSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        this.shooterSubsystem = shooterSubsystem;
        this.turretIntakeSubsystem = turretIntakeSubsystem;
        this.turretRotatorSubsystem = turretRotatorSubsystem;
        this.navx = NavX;
        addRequirements(
                drivetrainSubsystem,
                hopperSubsystem,
                intakeSubsystem,
                shooterSubsystem,
                turretIntakeSubsystem,
                turretRotatorSubsystem);
    }

    @Override
    public void initialize() {
        navx.zeroYaw();
        drivetrainSubsystem.rightMotor1.setSelectedSensorPosition(0);
        // d   rivetrainSubsystem.autostate = 1;
    }

    @Override
    public void execute() {
        // 1: shoot and move
        // 2: color wheel balls
        // 3: switch balls (raise intake?)
        int autoStrategy = 2;

        switch (autoStrategy) {
            case 1:
                drivetrainSubsystem.moveAuto(1, navx.getRawGyroZ());
                break;

            case 2:
                drivetrainSubsystem.moveAuto(2, navx.getRawGyroZ());
                if (drivetrainSubsystem.autostate == 4) {
                    taskCompleted = true;
                }
                break;

            case 3:
                drivetrainSubsystem.moveAuto(3, navx.getRawGyroZ());
                break;
        }
    }

    @Override
    public boolean isFinished() {
        return taskCompleted;
    }

    @Override
    public void end(boolean interrupted) {}
}
