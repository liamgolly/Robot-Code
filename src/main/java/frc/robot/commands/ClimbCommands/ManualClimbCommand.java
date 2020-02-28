package frc.robot.commands.ClimbCommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;

import static frc.robot.Constants.ButtonID.*;


public class ManualClimbCommand extends CommandBase {
    private final ClimbSubsystem climbSubsystem = ClimbSubsystem.getInstance();

    Joystick leftstick;
    Joystick rightstick;

    public ManualClimbCommand(Joystick leftStick, Joystick rightStick) {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        leftstick = leftStick;
        rightstick = rightStick;
        addRequirements(this.climbSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        climbSubsystem.activeLeftWinch(leftstick.getRawAxis(ManualWinchLeftAxisID));
        climbSubsystem.activeRightWinch(rightstick.getRawAxis(ManualWinchRightAxisID));
        climbSubsystem.ManualOverride = true;
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        climbSubsystem.deactivateLeftWinch();
        climbSubsystem.deactivateRightWinch();
        climbSubsystem.ManualOverride = false;
    }
}
