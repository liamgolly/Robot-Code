package frc.robot.subsystems.NonOISubsystems;

import java.util.Random;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LedControlSubsystem extends SubsystemBase {

    private static final LedControlSubsystem INSTANCE = new LedControlSubsystem();

    private LedControlSubsystem() {}

    AddressableLED m_led = new AddressableLED(0);
    AddressableLEDBuffer m_ledBuffer = new AddressableLEDBuffer(60);
    public void initialize(){
        m_led.setLength(m_ledBuffer.getLength());

        // Set the data
        m_led.setData(m_ledBuffer);
        m_led.start();
    }

    public void ledRainbowBarf(){
        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
            // Sets the specified LED to the RGB values for red
            Random rand = new Random();
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            m_ledBuffer.setRGB(i, r, g, b);
         }
         
         m_led.setData(m_ledBuffer);
      
    }

    public static LedControlSubsystem getInstance() {
        return INSTANCE;
    }
}
