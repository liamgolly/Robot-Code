package frc.robot.subsystems;

import static frc.robot.Constants.MotorID.*;
import static frc.robot.Constants.SensorID.hallSensorTurretRotator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.classes.AlphaTalon;

public class TurretRotatorSubsystem extends SubsystemBase {

    AlphaTalon turretRotator = new AlphaTalon(turretRotatorID);
    DigitalInput turretLimitSwitch = new DigitalInput(hallSensorTurretRotator);

    private static final TurretRotatorSubsystem INSTANCE = new TurretRotatorSubsystem();

    private TurretRotatorSubsystem() {}

    public void zeroAngle() {
        

    }



    public static TurretRotatorSubsystem getInstance() {
        return INSTANCE;
    }
}
