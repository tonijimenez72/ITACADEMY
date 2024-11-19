package n1exercise2;

public class Main {
    public static void main(String[] args) {
        Car one = new Car("Panda", 100);
        one.info();

        Car two = new Car("Ibiza TSI", 150);
        two.info();

        System.out.println("\nNon static methods:");
        one.accelerate();
        two.accelerate();

        System.out.println("\nStatic method:");
        Car.brake();
    }
}