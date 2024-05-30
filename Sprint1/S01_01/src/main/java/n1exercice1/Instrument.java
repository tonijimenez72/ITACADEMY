package n1exercice1;

abstract class Instrument {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static String name;
    protected static double price;

    public Instrument(String name, double price) {
        this.setName(name);
        this.setPrice(price);
    }

    public static String getName() {
        return name;
    }
    public static double getPrice() {
        return price;
    }

    public void setName(String name) {
        Instrument.name = name;
    }
    public void setPrice(double price) {
        Instrument.price = price;
    }

    public abstract void play();

   static{
        System.out.println(ANSI_GREEN + "Static initialization block:\n" + ANSI_RESET + "Ready, steady, go!\n");
    }

    {
        System.out.println(ANSI_YELLOW + "initialization blocks for instance:" + ANSI_RESET);
    }
}
