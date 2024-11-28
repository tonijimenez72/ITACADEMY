package n1exercise1;

public class OnsiteWorker extends Worker {
    private static final double FUEL = 100.0;

    public OnsiteWorker(String name, String surname, double pricePerHour) {
        super(name, surname, pricePerHour);
    }

    @Override
    public double calculateSalary(int hours) {
        return super.calculateSalary(hours) + FUEL;
    }
}