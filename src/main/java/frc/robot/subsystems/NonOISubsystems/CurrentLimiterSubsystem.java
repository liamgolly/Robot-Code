package frc.robot.subsystems.NonOISubsystems;

import static frc.robot.Constants.CurrentLimitingConstants.*;
import static frc.robot.Constants.MotorID.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.classes.AlphaTalon;
import java.util.Arrays;
public class CurrentLimiterSubsystem extends SubsystemBase {

    private static final CurrentLimiterSubsystem INSTANCE = new CurrentLimiterSubsystem();

    private CurrentLimiterSubsystem() {}


    private double limitDrivetrain = 0;
    private double limitClimb = 0;
    private double limitTurret = 0;
    private double limitBallTransport = 0;
    private double limitColorWheel = 0;
    
    private String limitingOrder[] = {"","","","",""};

    public boolean autoLimit = true;

    public void LimitCurrent(double currentCurrent) {
        if(autoLimit){
            if (currentCurrent > currentLimit) {
                for (String string : limitingOrder) {
                    if(limitMotor(string, true)){break;}
                }
                
            } else if (currentCurrent < currentLimit) {
                for (String string : limitingOrder) {
                    if(limitMotor(string, false)){break;}
                }
            }
        }
    }

    public boolean limitMotor(String group, boolean limit) {
        switch(group){
            case "driveTrain":
                if(limit){if(limitDrivetrain == 1){return false;}else{limiter(leftMotor1ID, limitDrivetrain+xStep);limiter(leftMotor2ID, limitDrivetrain+xStep);limiter(rightMotor1ID, limitDrivetrain+xStep);limiter(rightMotor2ID, limitDrivetrain+xStep);limitDrivetrain=limitDrivetrain+xStep;return true;}}else{limiter(leftMotor1ID, limitDrivetrain-xStep);limiter(leftMotor2ID, limitDrivetrain-xStep);limiter(rightMotor1ID, limitDrivetrain-xStep);limiter(rightMotor2ID, limitDrivetrain-xStep);limitDrivetrain=limitDrivetrain-xStep;return true;}

            case "climb":
                if(limit){if(limitClimb == 1){return false;}else{limiter(pvcExtenderID, limitClimb+xStep);limiter(rightWinchID, limitClimb+xStep);limiter(leftWinchID, limitClimb+xStep);limitClimb=limitClimb+xStep;return true;}}else{limiter(pvcExtenderID, limitClimb-xStep);limiter(rightWinchID, limitClimb-xStep);limiter(leftWinchID, limitClimb-xStep);limitClimb=limitClimb-xStep;return true;}

            
            case "turret":
                if(limit){if(limitTurret == 1){return false;}else{limiter(turretRotatorID, limitTurret+xStep);limiter(shooterID, limitTurret+xStep);limitTurret=limitTurret+xStep;return true;}}else{limiter(turretRotatorID, limitTurret-xStep);limiter(shooterID, limitTurret-xStep);limitTurret=limitTurret-xStep;return true;}

            
            case "ballTransport":
                if(limit){if(limitBallTransport == 1){return false;}else{limiter(intakeID, limitBallTransport+xStep);limiter(intakeRotatorID, limitBallTransport+xStep);limiter(turretIntakeID, limitBallTransport+xStep);limiter(hopperID, limitBallTransport+xStep);limitBallTransport=limitBallTransport+xStep;return true;}}else{limiter(intakeID, limitBallTransport-xStep);limiter(intakeRotatorID, limitBallTransport-xStep);limiter(turretIntakeID, limitBallTransport-xStep);limiter(hopperID, limitBallTransport-xStep);limitBallTransport=limitBallTransport-xStep;return true;}

            
            case "colorWheel":
                if(limit){if(limitColorWheel == 1){return false;}else{limiter(colorWheelID, limitColorWheel+xStep);limitColorWheel=limitColorWheel+xStep;return true;}}else{limiter(colorWheelID, limitColorWheel-xStep);limitColorWheel=limitColorWheel-xStep;return true;}

               
        }
        return false;
    }
    public void limiter(int motorid, double x){
        new AlphaTalon(motorid).set((1/((.5*x)+1))+2);
    }

    public static CurrentLimiterSubsystem getInstance() {
        return INSTANCE;
    }
}
