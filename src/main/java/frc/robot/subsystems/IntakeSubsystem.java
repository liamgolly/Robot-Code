package frc.robot.subsystems;
import static frc.robot.Constants.MotorID.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    WPI_TalonSRX intakeMotor = new WPI_TalonSRX(intakeID);
    

    private final static IntakeSubsystem INSTANCE = new IntakeSubsystem();


    private IntakeSubsystem() {

    }

    public void moveIntake() {

    }

    public void activateIntake() {

    }


    public int IntakeMotors() {
        int output = 0;
        if (intakeMotor.get() != 0) { output += 1; }

        return output;
    }

    public static IntakeSubsystem getInstance() {
        return INSTANCE;
    }

}

