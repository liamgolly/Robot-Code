package frc.robot.subsystems;

import static frc.robot.Constants.AutonomousConstants.*;
import static frc.robot.Constants.MotorID.*;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.classes.AlphaTalon;
import frc.robot.classes.DriveTrain;

public class DrivetrainSubsystem extends SubsystemBase {

    // 1: Forza, 2: CrabwalkBananna
    public static int drivemode = 1;
    private boolean quickTurnEnabled = false;
    public int autostate = 1;

    AlphaTalon leftMotor1 = new AlphaTalon(leftMotor1ID);
    AlphaTalon leftMotor2 = new AlphaTalon(leftMotor2ID);
    public AlphaTalon rightMotor1 = new AlphaTalon(rightMotor1ID);
    AlphaTalon rightMotor2 = new AlphaTalon(rightMotor2ID);
    DriveTrain driveTrain =
            new DriveTrain(
                    new SpeedControllerGroup(leftMotor1, leftMotor2),
                    new SpeedControllerGroup(rightMotor1, rightMotor2));

    private static final DrivetrainSubsystem INSTANCE = new DrivetrainSubsystem();

    private DrivetrainSubsystem() {}

    public void ArcadeDriveStraight(double speed, double rotation, double angle) {
        driveTrain.arcadeDriveStraight(speed, rotation, angle);
    }

    public void ArcadeDrive (double speed, double rotation) {
        driveTrain.tankDrive(speed, rotation);
    }

    public void CurvatureDrive(double speed, double rotation) {
        driveTrain.curvatureDrive(speed, rotation, true);
    }

    public void quickTurn() {
        quickTurnEnabled = !quickTurnEnabled;
    }



    public void moveAuto(int strat, double rotation) {


    }

    public static DrivetrainSubsystem getInstance() {
        return INSTANCE;
    }
}
