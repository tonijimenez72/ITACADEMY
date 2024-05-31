package n1exercise2;

public class Car {
    private static final String TRADEMARK = "SEAT";
    private static String model;
    private final int POWER;

    public Car(String model, int POWER) {
        Car.model = model;
        this.POWER = POWER;
    }

    public void info() {
        System.out.println("Estàs conduint un cotxe de la marca " + TRADEMARK + ", del model " + model + " amb una potència de " + POWER + " CV.");
    }

    public static void brake() {
        System.out.println("El vehicle està frenant.");
    }

    public void accelerate() {
        System.out.println("El vehicle està accelerant.");
    }
}
