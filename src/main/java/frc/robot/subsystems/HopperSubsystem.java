package frc.robot.subsystems;

import static frc.robot.Constants.HopperConstants.*;
import static frc.robot.Constants.MotorID.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.classes.AlphaTalon;

public class HopperSubsystem extends SubsystemBase {

    AlphaTalon hopperMotor = new AlphaTalon(hopperID);

    private static final HopperSubsystem INSTANCE = new HopperSubsystem();

    private HopperSubsystem() {}

    public void activateHopper() {
        hopperMotor.set(hopperPower);
    }

    public void deactiveHopper() {
        hopperMotor.set(0);
    }

    public static HopperSubsystem getInstance() {
        return INSTANCE;
    }
}
