package n01exercise3.vehicles;

public class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike's starting.");
    }

    @Override
    public void accelerate() {
        System.out.println("Bike's accelerating.");
    }

    @Override
    public void brake() {
        System.out.println("Bike's braking.");
    }
}