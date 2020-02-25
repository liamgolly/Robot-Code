package frc.robot.classes;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends DifferentialDrive {

    public DriveTrain(SpeedController leftMotor, SpeedController rightMotor) {
        super(leftMotor, rightMotor);
    }

    double zeroAngle;

    public void arcadeDriveStraight(double power, double rotation, double angle) {
        if (Math.abs(rotation) > 0) {
            super.arcadeDrive(power, rotation);
            zeroAngle = 0;
        } else {
            if (zeroAngle == 0) {
                zeroAngle = angle;
            }
            if (angle >= zeroAngle) {
                super.arcadeDrive(power, -.35);
            }
            if (angle < zeroAngle) {
                super.arcadeDrive(power, .35);
            }
            if (angle == zeroAngle) {
                super.arcadeDrive(power, 0);
            }


        }
        System.out.println(zeroAngle);
        System.out.println(angle);


        // super.arcadeDrive(0, 0);
    }

    @Override
    public void curvatureDrive(double power, double rotation, boolean quickTurn) {
        super.curvatureDrive(power, rotation, quickTurn);
        // super.curvatureDrive(0, 0, false);
    }

    @Override
    public void tankDrive(double leftPower, double rightPower) {
        super.tankDrive(leftPower, rightPower);
        // super.tankDrive(0, 0);
    }
}
