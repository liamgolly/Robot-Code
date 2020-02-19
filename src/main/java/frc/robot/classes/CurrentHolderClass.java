package frc.robot.classes;

public class CurrentHolderClass {
    public double[] motorCurrents = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    private static CurrentHolderClass INSTANCE = new CurrentHolderClass();

    public static CurrentHolderClass getInstance() {
        return INSTANCE;
    }
}
