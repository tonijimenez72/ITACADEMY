package n2exercise1.device;

import n2exercise1.feature.*;

public class Smartphone extends Telephone implements Camera, Clock {
    public Smartphone(String tradeMark, String model) {
        super(tradeMark, model);
    }

    @Override
    public void photo() {
        System.out.println("Doing a picture.");
    }

    @Override
    public void alarm() {
        System.out.println("Sounds the alarm.");
    }
}