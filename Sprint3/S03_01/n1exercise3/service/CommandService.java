package n1exercise3.service;

public class CommandService {
    private Command start;
    private Command brake;
    private Command accelerate;

    public void setStart(Command start) {
        this.start = start;
    }

    public void setBrake(Command brake) {
        this.brake = brake;
    }

    public void setAccelerate(Command accelerate) {
        this.accelerate = accelerate;
    }

    public void run() {
        start.execute();
        brake.execute();
        accelerate.execute();
    }
}

