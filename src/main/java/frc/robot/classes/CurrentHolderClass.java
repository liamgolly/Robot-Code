package frc.robot.classes;

import java.util.ArrayList;

public class CurrentHolderClass {
    public double[] currentMotorCurrents = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public double[][] historicalMotorCurrents = new double[500][];

    private static CurrentHolderClass INSTANCE = new CurrentHolderClass();

    public static CurrentHolderClass getInstance() {
        return INSTANCE;
    }
}
