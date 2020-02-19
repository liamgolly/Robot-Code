package frc.robot.classes;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class AlphaTalon extends WPI_TalonSRX {

    public static double[] MotorCurrents = {0,0,0,0,0,0,0,0,0,0,0,0,0};
    private int device;

    public AlphaTalon(int deviceNumber) {
        super(deviceNumber);
        device = deviceNumber;
    }

    @Override
    public void set(double speed) {
        super.set(speed);
        MotorCurrents[device] = super.getStatorCurrent();
    }
}
