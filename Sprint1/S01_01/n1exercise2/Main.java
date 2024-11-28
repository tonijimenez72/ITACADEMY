package n1exercise2;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Panda", 100);

        System.out.println("\nNon static methods:");

        car.info();

        car.accelerate();

        System.out.println("\nStatic method:");

        Car.brake();
    }
}