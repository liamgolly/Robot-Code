package frc.robot.subsystems;

import static frc.robot.Constants.MotorID.*;
import static frc.robot.Constants.ProtectionConstants.*;
import static frc.robot.Constants.intakeConstants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    WPI_TalonSRX intakeMotor = new WPI_TalonSRX(intakeID);
    CANSparkMax intakeRotator =
            new CANSparkMax(intakeRotatorID, CANSparkMaxLowLevel.MotorType.kBrushless);

    Timer stalltimer = new Timer();
    Timer endstalltimer = new Timer();

    boolean intakeStalling = false;

    private static final IntakeSubsystem INSTANCE = new IntakeSubsystem();

    private IntakeSubsystem() {}

    public void moveIntake(int direction, double power) {

        intakeRotator.set(direction * power);
    }

    public void activateIntake() {
        intakeProtection();
        if (!intakeStalling) {
            intakeMotor.set(intakePower);
        } else {
            intakeMotor.set(-1 * intakePower);
        }
    }

    public void disableIntake() {
        intakeMotor.set(0);
    }

    private void intakeProtection() {
        if (Math.abs(intakeMotor.getStatorCurrent()) > intakeCurrentLimit) {
            if (stalltimer.get() == 0) {
                stalltimer.start();
            }
            endstalltimer.reset();
        }
        if (Math.abs(intakeMotor.getStatorCurrent()) < intakeCurrentLimit) {
            if (endstalltimer.get() == 0) {
                endstalltimer.start();
            }
        }
        if (stalltimer.get() > intakeStallTime) {
            stalltimer.reset();
            intakeStalling = true;
        }
        if (endstalltimer.get() > intakeUnstallTime) {
            endstalltimer.reset();
            stalltimer.reset();
            intakeStalling = false;
        }
    }

    public int IntakeMotors() {
        int output = 0;
        if (intakeMotor.get() != 0) {
            output += 1;
        }
        // if (intakeRotator.get() != 0) {output += 1; }

        return output;
    }

    public static IntakeSubsystem getInstance() {
        return INSTANCE;
    }
}
