package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.MotorID.*;
import frc.robot.RobotContainer.*;

public class DrivetrainSubsystem extends SubsystemBase {


    WPI_TalonFX leftMotor1 = new WPI_TalonFX(leftMotor1ID);
    WPI_TalonFX leftMotor2 = new WPI_TalonFX(leftMotor2ID);
    WPI_TalonFX rightMotor1 = new WPI_TalonFX(rightMotor1ID);
    WPI_TalonFX rightMotor2 = new WPI_TalonFX(rightMotor2ID);
    DifferentialDrive driveTrain = new DifferentialDrive(new SpeedControllerGroup(rightMotor1, rightMotor2), new SpeedControllerGroup(leftMotor1, leftMotor2));

    private final static DrivetrainSubsystem INSTANCE = new DrivetrainSubsystem();

    private DrivetrainSubsystem() {

    }

    public void arcadeDrive(double speed, double rotation) {
        driveTrain.arcadeDrive(speed, rotation);
    }


    public int DrivetrainMotors() {
        int output = 0;
        if (leftMotor1.get() != 0) { output += 1; }
        if (leftMotor2.get() != 0) { output += 1; }
        if (rightMotor1.get() != 0) { output += 1; }
        if (rightMotor2.get() != 0) { output += 1; }

        return output;
    }

    public static DrivetrainSubsystem getInstance() {
        return INSTANCE;
    }

}

