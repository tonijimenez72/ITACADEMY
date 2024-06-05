package n1exercise1;

public class Worker {
    protected String name;
    protected String surname;
    protected double price;

    public Worker(String name, String surname, double price) {
        this.name = name;
        this.surname = surname;
        this.price = price;
    }

    public double calculateSalary(int hours) {
        return hours * price;
    }
}
