package frc.robot.subsystems;

import static frc.robot.Constants.AutonomousConstants.*;
import static frc.robot.Constants.MotorID.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.classes.AlphaTalon;

public class ClimbSubsystem extends SubsystemBase {

    AlphaTalon pvcExtender = new AlphaTalon(pvcExtenderID);
    AlphaTalon leftWinch = new AlphaTalon(leftWinchID);
    AlphaTalon rightWinch = new AlphaTalon(rightWinchID);

    public boolean pvcDone;
    public boolean ManualOverride;

    private static final ClimbSubsystem INSTANCE = new ClimbSubsystem();

    private ClimbSubsystem() {}

    public void raisePVC() {
        if (pvcExtender.getSelectedSensorPosition() * PVCEncoderInch < 35) {
            pvcExtender.set(.3);
            pvcDone = false;
        }
        else{
            pvcDone = true;
        }
    }
    public void lowerPVC() {
        if (pvcExtender.getSelectedSensorPosition() * PVCEncoderInch > 1) {
            pvcExtender.set(-.3);
            pvcDone = false;
        }
        else {
            pvcDone = true;
        }
    }

    public void resetLeftEncoder() {leftWinch.setSelectedSensorPosition(0); }
    public void resetRightEncoder() {rightWinch.setSelectedSensorPosition(0); }

    public double getAbsoluteBarAngle(double angle, String startingHigherSide) {

        double leftDisplacement;
        double rightDisplacement;

        double absoluteAngle = 0.0;

        if (leftWinch.getSelectedSensorPosition() > rightWinch.getSelectedSensorPosition()) {
            rightDisplacement = rightWinch.getSelectedSensorPosition();
            leftDisplacement = leftWinch.getSelectedSensorPosition() + Math.tan(angle) * HookDistance;

        }
        else {
            leftDisplacement = leftWinch.getSelectedSensorPosition();
            rightDisplacement = rightWinch.getSelectedSensorPosition() + Math.tan(angle) * HookDistance;

        }


        if (startingHigherSide.equals("left")) {
            absoluteAngle = Math.atan((leftDisplacement - rightDisplacement) / HookDistance);
        }

        if (startingHigherSide.equals("right")) {
            absoluteAngle = Math.atan((rightDisplacement - leftDisplacement) / HookDistance);
        }


        return absoluteAngle;
    }
    public double getLeftSideRobotHeight(double angle) {

        if (angle < 0) {
            return leftWinch.getSelectedSensorPosition() * WinchEncoderInch;
        }
        else {
            return (leftWinch.get() * WinchEncoderInch) + (Math.tan(angle) * HookDistance);
        }
    }
    public double getRightSideRobotHeight(double angle) {
        if (angle > 0) {
            return rightWinch.getSelectedSensorPosition() * WinchEncoderInch;
        }
        else {
            return (rightWinch.get() * WinchEncoderInch) + (Math.tan(angle) * HookDistance);
        }
    }
    public boolean leftWinchOnBar() { return leftWinch.getStatorCurrent() > 35; }
    public boolean rightWinchOnBar() {return rightWinch.getStatorCurrent() > 35; }

    public void activeLeftWinch(double power) {
        leftWinch.set(power);
    }
    public void activeRightWinch(double power) {
        rightWinch.set(power);
    }
    public void deactivateLeftWinch() {leftWinch.set(0); }
    public void deactivateRightWinch() {rightWinch.set(0); }



    public static ClimbSubsystem getInstance() {
        return INSTANCE;
    }
}
