package frc.robot.subsystems.NonOISubsystems;

import static frc.robot.Constants.CurrentLimitingConstants.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.classes.AlphaTalon;
import java.util.Arrays;

public class CurrentLimiterSubsystem extends SubsystemBase {

    private static final CurrentLimiterSubsystem INSTANCE = new CurrentLimiterSubsystem();

    private CurrentLimiterSubsystem() {}

    private int[] limitedMotors = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    }; // 0-not being limited 1-being limited
    public int[] motorID = {}; // most to least importance

    public void LimitCurrent(double currentCurrent) {
        if (Arrays.stream(limitedMotors).sum() != 13 && currentCurrent > currentLimit) {
            limitedMotors[12 - Arrays.stream(limitedMotors).sum()] =
                    1; // sets motors to limited in increasing order of importance
        }
        if (Arrays.stream(limitedMotors).sum() != 0 && currentCurrent < currentLimit) {
            limitedMotors[13 - Arrays.stream(limitedMotors).sum()] =
                    0; // sets motors to not limited in decreasing order of importance
        }
        for (int i : motorID) {
            switch (i) {
                case 1:
                    if (limitedMotors[1] == 1) {
                        // set motor speeds from motorID (done below)
                        new AlphaTalon(motorID[1]).set(0); // add function drop off for each motor
                    }
                    break;
                    // add case for each motor
            }
        }
    }

    public static CurrentLimiterSubsystem getInstance() {
        return INSTANCE;
    }
}
