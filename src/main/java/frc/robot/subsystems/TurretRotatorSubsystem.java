package frc.robot.subsystems;

import static frc.robot.Constants.MotorID.*;
import static frc.robot.Constants.SensorID.hallSensorTurretRotator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.classes.AlphaTalon;

public class TurretRotatorSubsystem extends SubsystemBase {

    AlphaTalon turretRotator = new AlphaTalon(turretRotatorID);

    private static final TurretRotatorSubsystem INSTANCE = new TurretRotatorSubsystem();

    private TurretRotatorSubsystem() {}


    public void zeroTurret(boolean sensorValue) {
        limitSwitchHit(sensorValue);
        if (sensorValue) { turretRotator.set(.2); }
        else { turretRotator.set(0); }
    }




    private void limitSwitchHit(boolean sensorValue) {
        if (!sensorValue) {
            turretRotator.setSelectedSensorPosition(0);
        }
    }

    public static TurretRotatorSubsystem getInstance() {
        return INSTANCE;
    }
}
