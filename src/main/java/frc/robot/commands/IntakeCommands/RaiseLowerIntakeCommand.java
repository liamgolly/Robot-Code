package frc.robot.commands.IntakeCommands;

import static frc.robot.Constants.ProtectionConstants.*;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class RaiseLowerIntakeCommand extends CommandBase {
  private final IntakeSubsystem intakeSubsystem;

  // 1 is raised, 2 is lowered
  int State = 1;

  public RaiseLowerIntakeCommand(IntakeSubsystem intakeSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
    addRequirements(intakeSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    intakeSubsystem.moveIntake(State, intakeRotatorPower);
  }

  @Override
  public boolean isFinished() {

    return false;
  }

  @Override
  public void end(boolean interrupted) {}
}
