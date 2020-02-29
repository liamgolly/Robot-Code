package frc.robot.commands.NonOICommands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NonOISubsystems.LedControlSubsystem;

public class LedControlCommand extends CommandBase {

    LedControlSubsystem ledControlSubsystem = LedControlSubsystem.getInstance();

    public LedControlCommand() {
        addRequirements(ledControlSubsystem);
    }

    
    @Override
    public void initialize() {
        ledControlSubsystem.initialize();
    }


    @Override
    public void execute() {
        ledControlSubsystem.ledRainbowBarf();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {}
}
