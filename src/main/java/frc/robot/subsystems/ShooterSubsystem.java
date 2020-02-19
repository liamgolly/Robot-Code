package frc.robot.subsystems;

import static frc.robot.Constants.MotorID.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

    WPI_TalonFX shooter = new WPI_TalonFX(shooterID);
    private final static ShooterSubsystem INSTANCE = new ShooterSubsystem();


    private ShooterSubsystem() {

    }

    public int ShooterMotors() {
        int output = 0;
        if (shooter.get() != 0) { output += 1; }

        return output;
    }

    public static ShooterSubsystem getInstance() {
        return INSTANCE;
    }

}

