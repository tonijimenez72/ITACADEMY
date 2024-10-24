package n3exercise1;

public class Main {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone();
        Generics generic = new Generics();

        generic.telefonMethod(smartphone);

        System.out.println(ANSI_YELLOW + "\nIt's a trap! We can't take a photo with a simple phone." + ANSI_RESET);
        generic.smartphoneMethod(smartphone);
    }
}