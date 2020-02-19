package frc.robot.subsystems;

import static frc.robot.Constants.MotorID.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ColorWheelSubsystem extends SubsystemBase {

    WPI_TalonSRX colorWheelSpinner = new WPI_TalonSRX(colorWheelID);

    private static final ColorWheelSubsystem INSTANCE = new ColorWheelSubsystem();

    private ColorWheelSubsystem() {}

    public int ColorWheelMotors() {
        int output = 0;
        if (colorWheelSpinner.get() != 0) {
            output += 1;
        }

        return output;
    }

    public static ColorWheelSubsystem getInstance() {
        return INSTANCE;
    }
}
