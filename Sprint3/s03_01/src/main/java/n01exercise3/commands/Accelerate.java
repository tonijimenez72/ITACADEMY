package n01exercise3.commands;

import n01exercise3.vehicles.Vehicle;

public class Accelerate implements Command {
    private final Vehicle vehicle;

    public Accelerate(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        System.out.println(vehicle + "'s accelerating.");
    }
}
