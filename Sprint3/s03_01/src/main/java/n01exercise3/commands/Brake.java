package n01exercise3.commands;

import n01exercise3.vehicles.Vehicle;

public class Brake implements Command {
    private final Vehicle vehicle;

    public Brake(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.brake();
    }
}
