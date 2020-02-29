package frc.robot.subsystems.NonOISubsystems;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LedControlSubsystem extends SubsystemBase {

    private static final LedControlSubsystem INSTANCE = new LedControlSubsystem();

    private LedControlSubsystem() {
    }

    AddressableLED m_led = new AddressableLED(0);
    AddressableLEDBuffer m_ledBuffer = new AddressableLEDBuffer(300);
    Ultrasonic ballSensor = new Ultrasonic(9, 8);

    public void initialize() {
        m_led.setLength(m_ledBuffer.getLength());

        // Set the data
        m_led.setData(m_ledBuffer);
        m_led.start();
        // System.out.println("ledSUBinit");
    }
    Timer timer = new Timer();
    public int dist;
    public void ledRainbowBarf() {
        TimerTask t2 = new TimerTask(){
        
            @Override
            public void run() {
                // TODO Auto-generated method stub
                ballSensor.ping();
            }
        };
        timer.schedule(t2, 10);
        TimerTask t = new TimerTask(){
            
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println(ballSensor.getRangeInches());
                dist = (int)ballSensor.getRangeInches();
            }
        };
        timer.schedule(t, 2);
        /*
        //System.out.println("ledSUBbarf");
        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
            // Sets the specified LED to the RGB values for red
            Random rand = new Random();
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            System.out.println("R: "+r+" G: "+g+" B: "+b);
            m_ledBuffer.setRGB(i, r, g, b);
         }
         */
        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
            if(i<(dist*3)){
                m_ledBuffer.setRGB(i, 0, 0, 56);
            }
            else{
                m_ledBuffer.setRGB(i, 0, 0, 0);
            }
        }
         m_led.setData(m_ledBuffer);
      
    }

    public static LedControlSubsystem getInstance() {
        return INSTANCE;
    }
}
