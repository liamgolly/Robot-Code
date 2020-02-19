package frc.robot.subsystems;

import static frc.robot.Constants.MotorID.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TurretIntakeSubsystem extends SubsystemBase {

    WPI_TalonSRX turretIntakeMotor = new WPI_TalonSRX(turretIntakeID);
    private static final TurretIntakeSubsystem INSTANCE = new TurretIntakeSubsystem();

    private TurretIntakeSubsystem() {}

    public int TurretIntakeMotors() {
        int output = 0;
        if (turretIntakeMotor.get() != 0) {
            output += 1;
        }

        return output;
    }

    public static TurretIntakeSubsystem getInstance() {
        return INSTANCE;
    }
}
