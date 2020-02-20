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
    private int[] tempLimitedMotors = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int[] motorID = {}; // most to least importance (needs to be filled with 13 motors)

    public void LimitCurrent(double currentCurrent) {
        if (Arrays.stream(limitedMotors).sum() != 13 && currentCurrent > currentLimit) {
            limitedMotors[12 - Arrays.stream(limitedMotors).sum()] =
                    1; // sets motors to limited in increasing order of importance
        }
        else if (Arrays.stream(limitedMotors).sum() != 0 && currentCurrent < currentLimit) {
            limitedMotors[13 - Arrays.stream(limitedMotors).sum()] =
                    0; // sets motors to not limited in decreasing order of importance
        }
        for (int i : motorID) {
            //only set motors that have changed in limit status (done below)
            if(limitedMotors[i] != tempLimitedMotors[i]){
                switch(i){
                    case 0:
                        if(limitedMotors[1] == 1){
                            //set motor speeds from motorID (done below)
                            new AlphaTalon(motorID[0]).set(0); //add function drop off to speed
                        }
                        else{
                            new AlphaTalon(motorID[0]).set(.25);
                        }
                    break;
                    case 1:
                        if(limitedMotors[2] == 1){
                            new AlphaTalon(motorID[1]).set(0); //add function drop off to speed
                        }
                        else{
                            new AlphaTalon(motorID[1]).set(.25);
                        }
                    break;
                    case 2:
                        if(limitedMotors[3] == 1){
                            new AlphaTalon(motorID[2]).set(0); //add function drop off to speed
                        }
                        else{
                            new AlphaTalon(motorID[2]).set(.25);
                        }
                    break;
                    case 3:
                        if(limitedMotors[4] == 1){
                            new AlphaTalon(motorID[3]).set(0); //add function drop off to speed
                        }
                        else{
                            new AlphaTalon(motorID[3]).set(.25);
                        }
                    break;
                    case 4:
                        if(limitedMotors[5] == 1){
                            new AlphaTalon(motorID[4]).set(0); //add function drop off to speed
                        }
                        else{
                            new AlphaTalon(motorID[4]).set(.25);
                        }
                    break;
                    case 5:
                        if(limitedMotors[6] == 1){
                            new AlphaTalon(motorID[5]).set(0); //add function drop off to speed
                        }
                        else{
                            new AlphaTalon(motorID[5]).set(.25);
                        }
                    break;
                    case 6:
                        if(limitedMotors[7] == 1){
                            new AlphaTalon(motorID[6]).set(0); //add function drop off to speed
                        }
                        else{
                            new AlphaTalon(motorID[6]).set(.25);
                        }
                    break;
                    case 7:
                        if(limitedMotors[8] == 1){
                            new AlphaTalon(motorID[7]).set(0); //add function drop off to speed
                        }
                        else{
                            new AlphaTalon(motorID[7]).set(.25);
                        }
                    break;
                    case 8:
                        if(limitedMotors[9] == 1){
                            new AlphaTalon(motorID[8]).set(0); //add function drop off to speed
                        }
                        else{
                            new AlphaTalon(motorID[8]).set(.25);
                        }
                    break;
                    case 9:
                        if(limitedMotors[10] == 1){
                            new AlphaTalon(motorID[9]).set(0); //add function drop off to speed
                        }
                        else{
                            new AlphaTalon(motorID[9]).set(.25);
                        }
                    break;
                    case 10:
                        if(limitedMotors[11] == 1){
                            new AlphaTalon(motorID[10]).set(0); //add function drop off to speed
                        }
                        else{
                            new AlphaTalon(motorID[10]).set(.25);
                        }
                    break;
                    case 11:
                        if(limitedMotors[12] == 1){
                            new AlphaTalon(motorID[11]).set(0); //add function drop off to speed
                        }
                        else{
                            new AlphaTalon(motorID[11]).set(.25);
                        }
                    break;
                    case 12:
                        if(limitedMotors[13] == 1){
                            new AlphaTalon(motorID[12]).set(0); //add function drop off to speed
                        }
                        else{
                            new AlphaTalon(motorID[12]).set(.25);
                        }
                        break;
                }
            }
            tempLimitedMotors[i] =
                    limitedMotors[i]; // set temps for comparison next time LimitCurrent() is called
        }
    }
    
    //could cause problems with LimitCurrent() (untested)
    //call after changing motorID
    public void resetLimitedMotors(){
        for(int i=0;i!=13;i++){
            limitedMotors[i] = 0;
            tempLimitedMotors[i] = 0;
        }
    }

    public static CurrentLimiterSubsystem getInstance() {
        return INSTANCE;
    }
}
