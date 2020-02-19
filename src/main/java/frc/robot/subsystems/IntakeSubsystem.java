package frc.robot.subsystems;
import static frc.robot.Constants.MotorID.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    WPI_TalonSRX intakeMotor = new WPI_TalonSRX(intakeID);
    CANSparkMax intakeRotator = new CANSparkMax(intakeRotatorID, CANSparkMaxLowLevel.MotorType.kBrushless);

    private final static IntakeSubsystem INSTANCE = new IntakeSubsystem();


    private IntakeSubsystem() {

    }

    public void moveIntake(int direction) {
        if (direction == -1) {

        }
        if (direction == 1) {

        }


    }

    public void activateIntake() {

    }

    public void intakeProtection() {

    }


    public int IntakeMotors() {
        int output = 0;
        if (intakeMotor.get() != 0) { output += 1; }
        if (intakeRotator.get() != 0) {output += 1; }

        return output;
    }

    public static IntakeSubsystem getInstance() {
        return INSTANCE;
    }

}

