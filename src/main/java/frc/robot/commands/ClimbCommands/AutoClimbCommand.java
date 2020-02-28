package frc.robot.commands.ClimbCommands;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;

import static frc.robot.Constants.ClimbConstants.*;


public class AutoClimbCommand extends CommandBase {
    private final ClimbSubsystem climbSubsystem = ClimbSubsystem.getInstance();
    AHRS navx;
    private String startSide;

    public AutoClimbCommand(AHRS NAVX) {
        navx = NAVX;
        addRequirements(climbSubsystem);
    }

    @Override
    public void initialize() {
        if (climbSubsystem.getRightSideRobotHeight(navx.getRoll()) > climbSubsystem.getLeftSideRobotHeight(navx.getRoll())) {
            startSide = "right";
        }
        else {
            startSide = "left";
        }
    }

    @Override
    public void execute() {
        if (!climbSubsystem.ManualOverride) {
            if (climbSubsystem.getRightSideRobotHeight(navx.getRoll()) < climbSubsystem.getLeftSideRobotHeight(navx.getRoll())) {
                climbSubsystem.activeRightWinch(WinchPower);
            }
            if (climbSubsystem.getRightSideRobotHeight(navx.getRoll()) > climbSubsystem.getLeftSideRobotHeight(navx.getRoll())) {
                climbSubsystem.activeLeftWinch(WinchPower);
            }
        }
    }

    @Override
    public boolean isFinished() {
        return Math.abs(climbSubsystem.getAbsoluteBarAngle(navx.getRoll(), startSide)) < 13;
    }

    @Override
    public void end(boolean interrupted) {
        climbSubsystem.deactivateRightWinch();
        climbSubsystem.deactivateLeftWinch();
    }
}
