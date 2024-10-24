package n1exercise3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        List<String> mesos = List.of("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        System.out.println(ANSI_GREEN + "-> Fear the power of the arrow ->" + ANSI_RESET);
        mesos.forEach(mes -> System.out.println(mes));
    }
}