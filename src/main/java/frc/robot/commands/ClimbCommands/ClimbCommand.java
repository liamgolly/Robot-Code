package frc.robot.commands.ClimbCommands;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;

public class ClimbCommand extends CommandBase {
    private final ClimbSubsystem climbSubsystem;
    private final Joystick leftStick;
    private final Joystick rightStick;

    public ClimbCommand(ClimbSubsystem climbSubsystem, Joystick LEFT, Joystick RIGHT) {

        leftStick = LEFT;
        rightStick = RIGHT;
        this.climbSubsystem = climbSubsystem;
        addRequirements(climbSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {}

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {}
}
