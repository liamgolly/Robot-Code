package frc.robot.subsystems.NonHISubsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CurrentLimiterSubsystem extends SubsystemBase {

  private static final CurrentLimiterSubsystem INSTANCE = new CurrentLimiterSubsystem();

  private CurrentLimiterSubsystem() {}

  public void LimitCurrent(int activeMotors) {}

  public static CurrentLimiterSubsystem getInstance() {
    return INSTANCE;
  }
}
