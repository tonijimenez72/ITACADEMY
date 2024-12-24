package n1exercise3.service;

import n1exercise3.entity.Vehicle;

public class Start implements Command{
    private final Vehicle vehicle;

    public Start(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        System.out.println(vehicle + "'s starting.");
    }
}
