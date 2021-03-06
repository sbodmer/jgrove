import grovepi.GrovePi;
import grovepi.Pin;
import grovepi.sensors.ButtonSensor;
import grovepi.sensors.Led;

/**
 * @author Dan Jackson, Newcastle University, 2015.
 */
public class ButtonLedTest {

	public static void main(String[] args) {
		final ButtonTest test = new ButtonTest();
		test.run();
	}

	private final GrovePi grovePi;
	private final ButtonSensor button;
	private final Led led;

	private ButtonTest() {
		grovePi = new GrovePi();
		button = grovePi.getDeviceFactory().createButtonSensor(Pin.DIGITAL_PIN_4);
		led = grovePi.getDeviceFactory().createLed(Pin.DIGITAL_PIN_3);
		run();
	}
	
	public void run() {
		for(;;) {
			boolean buttonPressed = button.isPressed();
			
			if (buttonPressed) {
                System.out.println("PRESSED");
	        } else {
                System.out.println("RELEASED");
	        }

			boolean ledLit = buttonPressed;
			led.setState(ledLit);
		}
	}

}
