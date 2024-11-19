package n2exercise1.devices;

import n2exercise1.interfaces.*;

public class Smartphone extends Telephone implements Camera, Clock {
    public Smartphone(String tradeMark, String model) {
        super(tradeMark, model);
    }

    public void photo() {
        System.out.println("Doing a picture.");
    }

    @Override
    public void alarm() {
        System.out.println("Sounds the alarm.");
    }
}