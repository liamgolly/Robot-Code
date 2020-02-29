package frc.robot.commands.NonOICommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.classes.CurrentHolderClass;
import frc.robot.subsystems.NonOISubsystems.CurrentLimiterSubsystem;
import java.util.Arrays;

public class BrownoutProtectionCommand extends CommandBase {

    CurrentLimiterSubsystem currentLimiterSubsystem = CurrentLimiterSubsystem.getInstance();

    public BrownoutProtectionCommand() {

        addRequirements(currentLimiterSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        double current = Arrays.stream(CurrentHolderClass.getInstance().currentMotorCurrents).sum();
        //        CurrentHolderClass.getInstance()
        //                .historicalMotorCurrents
        //                .add(CurrentHolderClass.getInstance().currentMotorCurrents);
        currentLimiterSubsystem.LimitCurrent(current);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {}
}
