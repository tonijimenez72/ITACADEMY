package n1exercise1;

public class OnlineWorker extends Worker {
    private static final double INTERNET = 50.0;

    public OnlineWorker(String name, String surname, double pricePerHour) {
        super(name, surname, pricePerHour);
    }

    @Override
    public double calculateSalary(int hours) {
        return super.calculateSalary(hours) + INTERNET;
    }
}
