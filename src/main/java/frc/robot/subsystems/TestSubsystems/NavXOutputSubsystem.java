package frc.robot.subsystems.TestSubsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NavXOutputSubsystem extends SubsystemBase {

    private static final NavXOutputSubsystem INSTANCE = new NavXOutputSubsystem();

    private NavXOutputSubsystem() {}

    public void printNavXValues(AHRS navx) {
        System.out.println("X Gyro: " + navx.getRawGyroX());
        System.out.println("Y Gyro: " + navx.getRawGyroY());
        System.out.println("Z Gyro: " + navx.getRawGyroZ());
        System.out.println("Angle? " + navx.getAngle());
    }

    public static NavXOutputSubsystem getInstance() {
        return INSTANCE;
    }
}
