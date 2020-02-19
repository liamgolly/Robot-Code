package frc.robot.subsystems;

import static frc.robot.Constants.MotorID.*;
import static frc.robot.Constants.TurretIntakeConstants.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.classes.AlphaTalon;

public class TurretIntakeSubsystem extends SubsystemBase {

    AlphaTalon turretIntakeMotor = new AlphaTalon(turretIntakeID);
    private static final TurretIntakeSubsystem INSTANCE = new TurretIntakeSubsystem();

    private TurretIntakeSubsystem() {}

    public void activateTurretIntake() {
        turretIntakeMotor.set(turretIntakePower);
    }

    public void deactivateTurretIntake() {
        turretIntakeMotor.set(0);
    }

    public static TurretIntakeSubsystem getInstance() {
        return INSTANCE;
    }
}
