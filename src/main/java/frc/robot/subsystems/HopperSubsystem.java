package frc.robot.subsystems;

import static frc.robot.Constants.MotorID.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HopperSubsystem extends SubsystemBase {

  WPI_TalonSRX hopperMotor = new WPI_TalonSRX(hopperID);

  private static final HopperSubsystem INSTANCE = new HopperSubsystem();

  private HopperSubsystem() {}

  public int HopperMotors() {
    int output = 0;
    if (hopperMotor.get() != 0) {
      output += 1;
    }

    return output;
  }

  public static HopperSubsystem getInstance() {
    return INSTANCE;
  }
}
