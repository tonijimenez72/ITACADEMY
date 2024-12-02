package n1exercise2;

public class Main {
    public static void main(String[] args) {
        Car.setModel("Panda");

        Car car = new Car(100);

        System.out.println("\nNon static methods:");

        car.info();

        car.accelerate();

        System.out.println("\nStatic method:");

        Car.brake();
    }
}