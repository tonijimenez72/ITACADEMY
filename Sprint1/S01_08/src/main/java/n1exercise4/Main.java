package n1exercise4;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        List<String> months = List.of("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        System.out.println(ANSI_YELLOW + ":: Reference them all! ::" + ANSI_RESET);

        months.forEach(System.out::println);
    }
}