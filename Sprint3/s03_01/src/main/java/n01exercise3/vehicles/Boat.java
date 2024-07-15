package n01exercise3.vehicles;

public class Boat implements Vehicle {
    @Override
    public void start() {
        System.out.println("Boat's starting.");
    }

    @Override
    public void accelerate() {
        System.out.println("Boat's accelerating.");
    }

    @Override
    public void brake() {
        System.out.println("Boat's braking.");
    }
}