package n2exercise1.devices;

public abstract class Telephone {
    private String tradeMark;
    private String model;

    public Telephone(String tradeMark, String model) {
        this.tradeMark = tradeMark;
        this.model = model;
    }

    public static void call(String number) {
        System.out.println("Calling: " + number + ".");
    }
}