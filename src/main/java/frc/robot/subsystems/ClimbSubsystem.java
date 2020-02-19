package frc.robot.subsystems;

import static frc.robot.Constants.MotorID.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.classes.AlphaTalon;

public class ClimbSubsystem extends SubsystemBase {

    AlphaTalon pvcExtender = new AlphaTalon(pvcExtenderID);
    AlphaTalon leftWinch = new AlphaTalon(leftWinchID);
    AlphaTalon rightWinch = new AlphaTalon(rightWinchID);

    private static final ClimbSubsystem INSTANCE = new ClimbSubsystem();

    private ClimbSubsystem() {}

    public int ClimbMotors() {
        int output = 0;
        if (pvcExtender.get() != 0) {
            output += 1;
        }
        if (leftWinch.get() != 0) {
            output += 1;
        }
        if (rightWinch.get() != 0) {
            output += 1;
        }

        return output;
    }

    public static ClimbSubsystem getInstance() {
        return INSTANCE;
    }
}
