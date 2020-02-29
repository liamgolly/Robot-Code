package frc.robot.commands.NonOICommands;

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
        //System.out.println("ledCMDinit");
    }


    @Override
    public void execute() {
        ledControlSubsystem.ledRainbowBarf();
        //System.out.println("ledCMDexe");
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {}
}
