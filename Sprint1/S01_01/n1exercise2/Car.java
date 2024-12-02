package n1exercise2;

public class Car {
    private static final String TRADEMARK = "SEAT";
    private static String model = "not set";
    private final int power;

    public Car(int power) {
        this.power = power;
    }

    public static String getModel() {
        return model;
    }

    public static void setModel(String model) {
        Car.model = model;
    }

    public void info() {
        System.out.println("You are driving a " + TRADEMARK + " car, model " + model + ", with a power of " + power + " HP.");
    }

    public static void brake() {
        System.out.println("The vehicle is braking.");
    }

    public void accelerate() {
        System.out.println("The vehicle is accelerating.");
    }
}