package frc.robot.commands.TestCommands;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TestSubsystems.NavXOutputSubsystem;

public class NavXOutputCommand extends CommandBase {
    private final NavXOutputSubsystem navXOutputSubsystem;
    private final AHRS navx;

    public NavXOutputCommand(NavXOutputSubsystem navXOutputSubsystem, AHRS NAVX) {
        navx = NAVX;
        this.navXOutputSubsystem = navXOutputSubsystem;
        addRequirements(navXOutputSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        navXOutputSubsystem.printNavXValues(navx);
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {}
}
