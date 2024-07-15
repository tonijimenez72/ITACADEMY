package n01exercise3;

import n01exercise3.commands.*;
import n01exercise3.invoker.Invoker;
import n01exercise3.vehicles.*;

public class Parking {
    public static void start(){
        Invoker commands = new Invoker();

        execute(commands, new Car());
        execute(commands, new Bike());
        execute(commands, new Plane());
        execute(commands, new Boat());
    }

    public static void execute(Invoker commands, Vehicle vehicle) {
        commands.setStart(new Start(vehicle));
        commands.setAccelerate(new Accelerate(vehicle));
        commands.setBrake(new Brake(vehicle));
        System.out.println("\n");

        commands.executeCommands();
    }
}
