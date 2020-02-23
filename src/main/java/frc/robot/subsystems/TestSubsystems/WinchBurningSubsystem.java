package frc.robot.subsystems.TestSubsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WinchBurningSubsystem extends SubsystemBase {

    public static boolean done = false;
    int old_count = 0;
    boolean below = true;

    WPI_TalonSRX motor = new WPI_TalonSRX(0);

    private final static WinchBurningSubsystem INSTANCE = new WinchBurningSubsystem();


    private WinchBurningSubsystem() {

    }

    public void reset() {
        motor.setSelectedSensorPosition(0);
        below = true;
        old_count = 0;
        done = false;
    }

    public void burn(int counter) {
        System.out.println(counter);
        //System.out.println(below);
        //System.out.println(done);
        if (!done) {
            if (motor.getSelectedSensorPosition() < 34 * 4096 / 5 && below) {
                motor.set(-.2);
            }
            if (motor.getSelectedSensorPosition() >= 34 * 4096 / 5 && below) { below = false; }

            if (motor.getSelectedSensorPosition() > 4096  && !below) {
                motor.set(0.1);
                //System.out.println(counter);
            }
            if (motor.getSelectedSensorPosition() < 4096  && !below) { below = true; done = true; }
        }

        if (counter > old_count) {
            done = false;
        }
        old_count = counter;
    }


    public static WinchBurningSubsystem getInstance() {
        return INSTANCE;
    }

}

