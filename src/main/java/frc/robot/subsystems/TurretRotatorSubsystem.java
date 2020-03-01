package frc.robot.subsystems;

import static frc.robot.Constants.MotorID.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.classes.AlphaTalon;
import frc.robot.classes.Limelight;

public class TurretRotatorSubsystem extends SubsystemBase {

    AlphaTalon turretRotator = new AlphaTalon(turretRotatorID);

    public double previous_error;
    public double integral;
    public double derivative;
    
    private Timer aimtimer = new Timer();

    Limelight limelight = new Limelight();

    Double error = limelight.getTx();

    private static final TurretRotatorSubsystem INSTANCE = new TurretRotatorSubsystem();

    private TurretRotatorSubsystem() {}

    public void turnTurretPower(Double motorpower) {
        turretRotator.set(motorpower);
    }

    public void turnTurretDegrees(Double degrees) {

    }

    public void zeroTurretEncoder(boolean sensorValue) {
        if (!sensorValue) {
            turretRotator.setSelectedSensorPosition(0);
        }
    }

    public static TurretRotatorSubsystem getInstance() {
        return INSTANCE;
    }
}
