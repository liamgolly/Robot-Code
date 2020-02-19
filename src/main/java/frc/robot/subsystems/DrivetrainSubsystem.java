package frc.robot.subsystems;

import static frc.robot.Constants.MotorID.*;
import static frc.robot.Constants.robotMovementConstants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {

    // 1: Forza, 2: CrabwalkBananna
    public static int drivemode = 1;

    WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(leftMotor1ID);
    WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(leftMotor2ID);
    WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(rightMotor1ID);
    WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(rightMotor2ID);
    DifferentialDrive driveTrain =
            new DifferentialDrive(
                    new SpeedControllerGroup(leftMotor1, leftMotor2),
                    new SpeedControllerGroup(rightMotor1, rightMotor2));

    private static final DrivetrainSubsystem INSTANCE = new DrivetrainSubsystem();

    private DrivetrainSubsystem() {}

    public void ArcadeDrive(double speed, double rotation) {
        driveTrain.arcadeDrive(speed, rotation);
    }

    public void changeDriveMode() {
        if (DrivetrainSubsystem.drivemode == 1) {
            drivemode = 2;
        } else {
            drivemode = 1;
        }
    }

    public int DrivetrainMotors() {
        int output = 0;
        if (leftMotor1.get() != 0) {
            output += 1;
        }
        if (leftMotor2.get() != 0) {
            output += 1;
        }
        if (rightMotor1.get() != 0) {
            output += 1;
        }
        if (rightMotor2.get() != 0) {
            output += 1;
        }

        return output;
    }

    public static DrivetrainSubsystem getInstance() {
        return INSTANCE;
    }
}
