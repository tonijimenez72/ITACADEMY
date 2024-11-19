package n1exercise1.instruments;

abstract class Instrument {

    protected String name;
    protected double price;

    public Instrument(String name, double price) {
        this.setName(name);
        this.setPrice(price);
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void play();

    static{
        System.out.println("Static initialization block.");
    }

    {
        System.out.println("\nInstance initialization block:");
    }
}