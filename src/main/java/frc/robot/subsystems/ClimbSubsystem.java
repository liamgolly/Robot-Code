package frc.robot.subsystems;

import static frc.robot.Constants.MotorID.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSubsystem extends SubsystemBase {

    WPI_TalonSRX pvcExtender = new WPI_TalonSRX(pvcExtenderID);
    WPI_TalonSRX leftWinch = new WPI_TalonSRX(leftWinchID);
    WPI_TalonSRX rightWinch = new WPI_TalonSRX(rightWinchID);

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
