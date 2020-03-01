package frc.robot.classes;

import edu.wpi.first.networktables.NetworkTableInstance;

import java.util.HashMap;

public class Limelight {

    public Limelight(){

    }

    /**
     * @return The offset from crosshair to target, -29.8 to 29.8 degrees
     */
    public Double getTx() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    }

    /**
     * @return Vertical offset from crosshair to target, -24.85 to 24.85 degrees
     */
    public Double getTy() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
    }

    /**
     * @return Whether or not the target is visible, 1 or 0
     */
    public Double isTargetVisible() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
    }

    /**
     * @return area the target takes up in the image, can be used to approximate the angle. Between 0% and 100%
     */
    public Double getTargetArea() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
    }

    /**
     * @return Gets the skew of the target relative to the limelight, between -90 and 0
     */
    public Double getSkew() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts").getDouble(0);
    }

    /**
     * @return Gets the latency of the pipeline, including 11 seconds for the delay of image capture.
     */
    public Double getLatency() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tl").getDouble(0) + 11;
    }

    /**
     * @return Gets the length of the shortest side of the bounding box in pixels
     */
    public Double getShortSideLength() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tshort").getDouble(0);
    }

    /**
     * @return Gets the length of the shortest side of the bounding box in pixels
     */
    public Double getLongSideLength() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tlong").getDouble(0);
    }

    /**
     * @return Gets the active pipeline number
     */
    public Double getPipeline() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("getpipeline").getDouble(0);
    }

    /**
     * @return Gets the 3d camtran values in a hashmap, with the indices x, y, x/y, pitch, roll and yaw
     */
    public HashMap<String, Double> getCamtran() {
        Double[] doubleArray = NetworkTableInstance.getDefault().getTable("limelight").getEntry("camtran").
                getDoubleArray(new Double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0});

        HashMap<String, Double> hashMap = new HashMap<>();

        hashMap.put("x", doubleArray[0]);
        hashMap.put("y", doubleArray[1]);
        hashMap.put("y/z", doubleArray[2]);
        hashMap.put("pitch", doubleArray[3]);
        hashMap.put("yaw", doubleArray[4]);
        hashMap.put("roll", doubleArray[5]);

        return hashMap;
    }

    public void setLEDState(LEDStates state) {
        switch (state) {
            case ON:
                NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3);
                break;
            case OFF:
                NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
                break;
            case BLINK:
                NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(2);
                break;
            case PIPELINE:
                NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
                break;
        }
    }

    public void setOperationMode(OperationMode mode) {
        switch (mode) {
            case VISION_PROCESSOR:
                NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0);
                break;
            case DRIVER_CAMERA:
                NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1);
                break;
        }
    }

    public void setPipeline(int pipeline) {
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(pipeline);
    }

    public void setStream(StreamingMode mode) {
        switch (mode) {
            case STANDARD:
                NetworkTableInstance.getDefault().getTable("limelight").getEntry("stream").setNumber(0);
                break;
            case PiP_MAIN:
                NetworkTableInstance.getDefault().getTable("limelight").getEntry("stream").setNumber(1);
                break;
            case PiP_SECONDARY:
                NetworkTableInstance.getDefault().getTable("limelight").getEntry("stream").setNumber(2);
                break;
        }
    }

    public void setSnapshot(Boolean state) {
        if (state) {
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("snapshot").setNumber(1);
        } else {
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("snapshot").setNumber(0);
        }
    }

    public enum LEDStates {
        PIPELINE,
        OFF,
        BLINK,
        ON
    }

    public enum OperationMode {
        VISION_PROCESSOR,
        DRIVER_CAMERA
    }

    public enum StreamingMode {
        STANDARD,
        PiP_MAIN,
        PiP_SECONDARY
    }

    public enum SnapshotMode {

    }
}
