package n1exercise2;

public class OnsiteWorker extends Worker {
    private static final double FUEL = 100.0;

    public OnsiteWorker(String name, String surname, double pricePerHour) {
        super(name, surname, pricePerHour);
    }

    @Override
    public double calculateSalary(int hours) {
        return super.calculateSalary(hours) + FUEL;
    }

    @Deprecated
    public void deprecate() {
        System.out.println("Deprecated method in Onsite workers.");
    }
}