package frc.robot.subsystems;

import static frc.robot.Constants.MotorID.*;
import static frc.robot.Constants.SensorID.hallSensorTurretRotator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.classes.AlphaTalon;

public class TurretRotatorSubsystem extends SubsystemBase {

    AlphaTalon turretRotator = new AlphaTalon(turretRotatorID);

    private double p;
    private double i = 0;
    private double d = 0;
    public double previous_error;
    public double integral;
    public double derivative;

    private double motorpower = 0;

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry targetx = table.getEntry("tx");

    private double error = targetx.getDouble(0);


    private static final TurretRotatorSubsystem INSTANCE = new TurretRotatorSubsystem();

    private TurretRotatorSubsystem() {}

    public void zeroTurret(boolean sensorValue) {
        limitSwitchHit(sensorValue);
        if (sensorValue) {
            turretRotator.set(.2);
        } else {
            turretRotator.set(0);
        }
    }

    public void aimTurret() {

        integral += error * 0.02;
        derivative = (error - previous_error) / 0.02;

        if (targetx.getDouble(0) > 1.0) {
            motorpower = (p * error) + (i * integral) + (d * derivative);
        }
        else if (targetx.getDouble(0) < 1.0) {
            motorpower = -1 * ((p * error) + (i * integral) + (d * derivative));
        }
        else {
            motorpower = 0;
        }

        turretRotator.set(motorpower);

        previous_error = error;
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
