package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.MotorID.*;

public class TurretRotatorSubsystem extends SubsystemBase {

    WPI_TalonSRX turretRotator = new WPI_TalonSRX(turretRotatorID);

    private final static TurretRotatorSubsystem INSTANCE = new TurretRotatorSubsystem();

    private TurretRotatorSubsystem() {

    }

    public int TurretRotatorMotors() {
        int output = 0;
        if (turretRotator.get() != 0) { output += 1; }

        return output;
    }

    public static TurretRotatorSubsystem getInstance() {
        return INSTANCE;
    }

}

