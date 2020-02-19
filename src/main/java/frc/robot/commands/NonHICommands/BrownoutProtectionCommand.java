package frc.robot.commands.NonHICommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.HopperSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.NonHISubsystems.CurrentLimiterSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TurretIntakeSubsystem;
import frc.robot.subsystems.TurretRotatorSubsystem;

public class BrownoutProtectionCommand extends CommandBase {
  private final ClimbSubsystem climbSubsystem;
  private final ColorWheelSubsystem colorWheelSubsystem;
  private final CurrentLimiterSubsystem currentLimiterSubsystem;
  private final DrivetrainSubsystem drivetrainSubsystem;
  private final HopperSubsystem hopperSubsystem;
  private final IntakeSubsystem intakeSubsystem;
  private final ShooterSubsystem shooterSubsystem;
  private final TurretIntakeSubsystem turretIntakeSubsystem;
  private final TurretRotatorSubsystem turretRotatorSubsystem;

  public BrownoutProtectionCommand(
      ClimbSubsystem climbSubsystem,
      ColorWheelSubsystem colorWheelSubsystem,
      CurrentLimiterSubsystem currentLimiterSubsystem,
      DrivetrainSubsystem drivetrainSubsystem,
      HopperSubsystem hopperSubsystem,
      IntakeSubsystem intakeSubsystem,
      ShooterSubsystem shooterSubsystem,
      TurretIntakeSubsystem turretIntakeSubsystem,
      TurretRotatorSubsystem turretRotatorSubsystem) {
    this.climbSubsystem = climbSubsystem;
    this.colorWheelSubsystem = colorWheelSubsystem;
    this.currentLimiterSubsystem = currentLimiterSubsystem;
    this.drivetrainSubsystem = drivetrainSubsystem;
    this.hopperSubsystem = hopperSubsystem;
    this.intakeSubsystem = intakeSubsystem;
    this.shooterSubsystem = shooterSubsystem;
    this.turretIntakeSubsystem = turretIntakeSubsystem;
    this.turretRotatorSubsystem = turretRotatorSubsystem;
    addRequirements(
        climbSubsystem,
        colorWheelSubsystem,
        currentLimiterSubsystem,
        drivetrainSubsystem,
        hopperSubsystem,
        intakeSubsystem,
        shooterSubsystem,
        turretIntakeSubsystem,
        turretRotatorSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    int input =
        climbSubsystem.ClimbMotors()
            + colorWheelSubsystem.ColorWheelMotors()
            + drivetrainSubsystem.DrivetrainMotors()
            + hopperSubsystem.HopperMotors()
            + intakeSubsystem.IntakeMotors()
            + shooterSubsystem.ShooterMotors()
            + turretIntakeSubsystem.TurretIntakeMotors()
            + turretRotatorSubsystem.TurretRotatorMotors();

    currentLimiterSubsystem.LimitCurrent(input);
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {}
}
