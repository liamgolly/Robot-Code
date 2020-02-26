package frc.robot.subsystems;

import static frc.robot.Constants.MotorID.*;
import static frc.robot.Constants.ShooterConstants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.classes.AlphaTalon;

public class ShooterSubsystem extends SubsystemBase {

    AlphaTalon shooter = new AlphaTalon(shooterID);
    private static final ShooterSubsystem INSTANCE = new ShooterSubsystem();

    private ShooterSubsystem() {}

    public void Shoot() {
        shooter.set(shooterPower);
        System.out.println(shooter.getSelectedSensorVelocity());
    }

    public void stopShooter() {
        shooter.set(0);
    }

    public static ShooterSubsystem getInstance() {
        return INSTANCE;
    }
}
