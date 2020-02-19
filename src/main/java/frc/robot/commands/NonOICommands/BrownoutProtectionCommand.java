package frc.robot.commands.NonOICommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.classes.AlphaTalon;
import frc.robot.subsystems.NonOISubsystems.CurrentLimiterSubsystem;

public class BrownoutProtectionCommand extends CommandBase {

    CurrentLimiterSubsystem currentLimiterSubsystem;

    public BrownoutProtectionCommand(CurrentLimiterSubsystem m_currentLimiterSubsystem) {

        currentLimiterSubsystem = m_currentLimiterSubsystem;

        addRequirements(currentLimiterSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        double current = 0;
        for (int i = 0; i < 13; i++) {
            current += AlphaTalon.MotorCurrents[i];
        }
        currentLimiterSubsystem.LimitCurrent(current);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {}
}
