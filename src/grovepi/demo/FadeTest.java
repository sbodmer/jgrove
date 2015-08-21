package grovepi.demo;

import java.io.IOException;

import grovepi.GrovePi;
import grovepi.Pin;
import grovepi.sensors.Led;
import grovepi.sensors.RotaryAngleSensor;

public class FadeTest {

	public static void main(String[] args) throws IOException {
		final FadeTest test = new FadeTest();
		test.run();
	}

	private final GrovePi grovePi;
	private final RotaryAngleSensor rotary;
	private final Led led;

	private FadeTest() {
		grovePi = new GrovePi();
		rotary = grovePi.getDeviceFactory().createRotaryAngleSensor(Pin.ANALOG_PIN_0);
		led = grovePi.getDeviceFactory().createLed(Pin.DIGITAL_PIN_2);
		run();
	}
	
	public void run() {
		for(;;) {
			int value = rotary.getValue();
			float outputValue = value / 1024.0f;
			
            System.out.println("" + value + " => " + outputValue + "");

			led.setState(outputValue);
		}
	}

}
