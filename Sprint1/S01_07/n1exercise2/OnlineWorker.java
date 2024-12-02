package n1exercise2;

public class OnlineWorker extends Worker {
    private static final double INTERNET = 50.0;

    public OnlineWorker(String name, String surname, double pricePerHour) {
        super(name, surname, pricePerHour);
    }

    @Override
    public double calculateSalary(int hours) {
        return hours * getPricePerHour() + INTERNET;
    }

    @Deprecated
    public void deprecate() {
        System.out.println("Deprecated method in online workers.");
    }
}