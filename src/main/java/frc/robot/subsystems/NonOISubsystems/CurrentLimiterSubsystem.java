package frc.robot.subsystems.NonOISubsystems;

import static frc.robot.Constants.CurrentLimitingConstants.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CurrentLimiterSubsystem extends SubsystemBase {

    private static final CurrentLimiterSubsystem INSTANCE = new CurrentLimiterSubsystem();

    private CurrentLimiterSubsystem() {}

    public void LimitCurrent(double currentCurrent) {
        if (currentCurrent > currentLimit) {
            // do stuff
        }
    }

    public static CurrentLimiterSubsystem getInstance() {
        return INSTANCE;
    }
}
