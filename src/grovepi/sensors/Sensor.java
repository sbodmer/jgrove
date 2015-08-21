package grovepi.sensors;

import grovepi.GrovePi;
import grovepi.PinMode;

public abstract class Sensor
{
    protected final GrovePi device;
    protected final int pin;

    protected Sensor(GrovePi device, int pin, PinMode pinMode) {
        device.pinMode(pin, pinMode);
        this.device = device;
        this.pin = pin;
    }

    public boolean getState() {
    	return device.digitalRead(pin) == 0 ? SensorStatus.OFF : SensorStatus.ON;
    }

    public void setState(float newState) {
    	int value = (int)(255 * newState + 0.5);
System.out.println("pin-" + pin + "=" + value);
        device.analogWrite(pin, value);
    }
    
    public void setState(int newState) {
        device.digitalWrite(pin, (byte)newState);
    }
    
    public void setState(boolean newState) {
    	setState(!newState ? 0 : 1);
    }
    
}
