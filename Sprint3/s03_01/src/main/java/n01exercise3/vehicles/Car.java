package n01exercise3.vehicles;

public class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car's starting.");
    }

    @Override
    public void accelerate() {
        System.out.println("Car's accelerating.");
    }

    @Override
    public void brake() {
        System.out.println("Car's braking.");
    }
}