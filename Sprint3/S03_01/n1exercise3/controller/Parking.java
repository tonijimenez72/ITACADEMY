package n1exercise3.controller;

import n1exercise3.entity.*;
import n1exercise3.service.Accelerate;
import n1exercise3.service.Brake;
import n1exercise3.service.CommandService;
import n1exercise3.service.Start;

public class Parking {
    public static void run(){
        CommandService commandService = new CommandService();

        execute(commandService, new Car());
        execute(commandService, new Bike());
        execute(commandService, new Plane());
        execute(commandService, new Boat());
    }

    public static void execute(CommandService command, Vehicle vehicle) {
        command.setStart(new Start(vehicle));
        command.setAccelerate(new Accelerate(vehicle));
        command.setBrake(new Brake(vehicle));
        System.out.println("\n");

        command.run();
    }
}
