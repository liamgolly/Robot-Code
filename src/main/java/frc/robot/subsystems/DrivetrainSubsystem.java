package frc.robot.subsystems;

import static frc.robot.Constants.AutonomousConstants.*;
import static frc.robot.Constants.MotorID.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.classes.DriveTrain;

public class DrivetrainSubsystem extends SubsystemBase {

    // 1: Forza, 2: CrabwalkBananna
    public static int drivemode = 1;
    private boolean quickTurnEnabled = false;
    public int autostate = 1;

    WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(leftMotor1ID);
    WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(leftMotor2ID);
    public WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(rightMotor1ID);
    WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(rightMotor2ID);
    DriveTrain driveTrain =
            new DriveTrain(
                    new SpeedControllerGroup(leftMotor1, leftMotor2),
                    new SpeedControllerGroup(rightMotor1, rightMotor2));

    private static final DrivetrainSubsystem INSTANCE = new DrivetrainSubsystem();

    private DrivetrainSubsystem() {}

    public void ArcadeDrive(double speed, double rotation) {
        driveTrain.arcadeDrive(speed, rotation);
//        leftMotor1.configContinuousCurrentLimit(38);
//        leftMotor2.configContinuousCurrentLimit(38);
//        rightMotor1.configContinuousCurrentLimit(38);
//        rightMotor2.configContinuousCurrentLimit(38);


//        System.out.println("Left Motor 1:  " + leftMotor1.getStatorCurrent());
//        System.out.println("Left Motor 2: " + leftMotor2.getStatorCurrent());
//
//        System.out.println("Right Motor 1: " + rightMotor1.getStatorCurrent());
//        System.out.println("Right Motor 2: " + rightMotor2.getStatorCurrent());
    }

    public void CurvatureDrive(double speed, double rotation) {
        driveTrain.curvatureDrive(speed, rotation,  quickTurnEnabled);
    }

    public void quickTurn() {
        quickTurnEnabled = !quickTurnEnabled;
    }

    public void changeDriveMode() {
        if (DrivetrainSubsystem.drivemode == 1) {
            drivemode = 2;
        } else {
            drivemode = 1;
        }
    }

    public void moveAuto(int strat, double rotation) {

        switch(strat) {
            case 2:
                switch(autostate) {
                    case 1:
                    case 3:
                        driveTrain.arcadeDrive(.35, 0);

                        if(rightMotor1.getSelectedSensorPosition() * DrivetrainEncoderInch > 48) {
                            autostate ++;
                            rightMotor1.setSelectedSensorPosition(0);
                        }
                        break;

                    case 2:
                        System.out.println(rotation);
                        driveTrain.tankDrive(-0.3, .3);
                        if (rotation > 170) { autostate++; }
                        break;

                }
                break;
        }



    }

    public static DrivetrainSubsystem getInstance() { return INSTANCE; }
}
