package frc.robot.classes;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends DifferentialDrive {

    public DriveTrain(SpeedController leftMotor, SpeedController rightMotor) {
        super(leftMotor, rightMotor);
    }

    @Override
    public void arcadeDrive(double power, double rotation) {
        super.arcadeDrive(power, rotation);
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
