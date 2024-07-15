package n01exercise3.vehicles;

public class Plane implements Vehicle {
    @Override
    public void start() {
        System.out.println("Plane's starting.");
    }

    @Override
    public void accelerate() {
        System.out.println("Plane's accelerating.");
    }

    @Override
    public void brake() {
        System.out.println("Plane's braking.");
    }
}