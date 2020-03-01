package frc.robot.subsystems;

import static frc.robot.Constants.MotorID.*;
import static frc.robot.Constants.ShooterConstants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.classes.AlphaTalon;
import frc.robot.classes.Limelight;

import java.util.Dictionary;
import java.util.HashMap;

public class ShooterSubsystem extends SubsystemBase {

    Limelight limelight = new Limelight();
    AlphaTalon shooter = new AlphaTalon(shooterID);
    private static final ShooterSubsystem INSTANCE = new ShooterSubsystem();

    private ShooterSubsystem() {}

    public void Shoot() {
        shooter.set(shooterPower);
//        System.out.println(shooter.getSelectedSensorVelocity());
    }

    public void stopShooter() {
        shooter.set(0);
    }

    public double CalcTurretDistance() {
        double height = 10;
        return height/Math.tan(limelight.getTy());
    }

    public static ShooterSubsystem getInstance() {
        return INSTANCE;
    }
}
