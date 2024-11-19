package n1exercise2;

public class Car {
    private static String trademark = "SEAT";
    private static String model;
    private final int power;

    public Car(String model, int power) {
        Car.model = model;
        this.power = power;
    }

    public void info() {
        System.out.println("You are driving a " + trademark + " car, model " + model + ", with a power of " + power + " HP.");
    }

    public static void brake() {
        System.out.println("The vehicle is braking.");
    }

    public void accelerate() {
        System.out.println("The vehicle is accelerating.");
    }
}