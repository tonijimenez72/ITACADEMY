package n1exercise1;

public abstract class Worker {
    private String name;
    private String surname;
    private double pricePerHour;

    public Worker(String name, String surname, double pricePerHour) {
        this.name = name;
        this.surname = surname;
        this.pricePerHour = pricePerHour;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public abstract double calculateSalary(int hours);

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
