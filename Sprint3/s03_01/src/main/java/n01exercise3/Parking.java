package n01exercise3;

import n01exercise3.commands.*;
import n01exercise3.vehicles.*;

public class Parking {
    public static void start(){
        RunCommand commands = new RunCommand();

        execute(commands, new Car());
        execute(commands, new Bike());
        execute(commands, new Plane());
        execute(commands, new Boat());
    }

    public static void execute(RunCommand commands, Vehicle vehicle) {
        commands.setStart(new Start(vehicle));
        commands.setAccelerate(new Accelerate(vehicle));
        commands.setBrake(new Brake(vehicle));
        System.out.println("\n");

        commands.executeCommands();
    }
}
