package n1exercice2;

public class Main {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {


        Car one = new Car("Panda", 100);
        one.info();
        one.accelerate();
        one.brake();

        System.out.println(ANSI_GREEN + "\nDon't miss the static Panda!" + ANSI_RESET);
        Car two = new Car("Ibiza TSI", 150);
        two.info();
        two.accelerate();
        two.brake();

        System.out.println(ANSI_GREEN + "\nLet's do the static brake!" + ANSI_RESET);
        Car.brake();
    }
}