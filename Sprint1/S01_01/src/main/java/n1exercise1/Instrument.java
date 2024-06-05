package n1exercise1;

abstract class Instrument {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

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
        System.out.println(ANSI_GREEN + "Static initialization block:\n" + ANSI_RESET + "Ready, steady, go!\n");
    }

    {
        System.out.println(ANSI_YELLOW + "initialization blocks for instance:" + ANSI_RESET);
    }
}
