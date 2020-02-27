package frc.robot.classes;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class AlphaTalon extends WPI_TalonSRX {

    private int device;

    public AlphaTalon(int deviceNumber) {
        super(deviceNumber);
        device = deviceNumber;
    }

    @Override
    public void set(double speed) {
        super.set(speed);
        CurrentHolderClass.getInstance().currentMotorCurrents[device] = super.getStatorCurrent();
    }
}
