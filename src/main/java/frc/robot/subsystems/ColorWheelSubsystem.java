package frc.robot.subsystems;

import static frc.robot.Constants.MotorID.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.classes.AlphaTalon;

public class ColorWheelSubsystem extends SubsystemBase {

    AlphaTalon colorWheelSpinner = new AlphaTalon(colorWheelID);

    private static final ColorWheelSubsystem INSTANCE = new ColorWheelSubsystem();

    private ColorWheelSubsystem() {}

    public static ColorWheelSubsystem getInstance() {
        return INSTANCE;
    }
}
