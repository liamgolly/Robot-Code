package frc.robot.commands.ClimbCommands;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;

import static frc.robot.Constants.ClimbConstants.*;


public class LiftInchCommand extends CommandBase {
    private final ClimbSubsystem climbSubsystem = ClimbSubsystem.getInstance();
    AHRS navx;
    double leftBarHeight;
    double rightBarHeight;

    public LiftInchCommand(AHRS NAVX) {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        navx = NAVX;
        addRequirements(this.climbSubsystem);
    }

    @Override
    public void initialize() {
        leftBarHeight = 0;
        rightBarHeight = 0;
    }

    @Override
    public void execute() {
        climbSubsystem.activeLeftWinch(WinchPower);
        climbSubsystem.activeRightWinch(WinchPower);
        if (leftBarHeight == 0 && climbSubsystem.leftWinchOnBar()) {leftBarHeight = climbSubsystem.getLeftSideRobotHeight(navx.getRoll()); }
        if (rightBarHeight == 0 && climbSubsystem.rightWinchOnBar()) {rightBarHeight = climbSubsystem.getRightSideRobotHeight(navx.getRoll()); }
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return ((leftBarHeight - climbSubsystem.getLeftSideRobotHeight(navx.getRoll()) > InchLiftTolerance) && (rightBarHeight - climbSubsystem.getRightSideRobotHeight(navx.getRoll()) > InchLiftTolerance));
    }

    @Override
    public void end(boolean interrupted) {
        climbSubsystem.deactivateLeftWinch();
        climbSubsystem.deactivateRightWinch();
    }
}
