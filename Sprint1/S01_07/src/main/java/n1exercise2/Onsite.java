package n1exercise2;

class Onsite extends Worker {
    private static double fuel = 100.0;

    public Onsite(String name, String surname, double price) {
        super(name, surname, price);
    }

    @Override
    public double calculateSalary(int hours) {
        return (super.calculateSalary(hours) + fuel);
    }

    @Deprecated
    public String deprecate() {
        return "Onsite workers will have his own workplace.";
    }
}