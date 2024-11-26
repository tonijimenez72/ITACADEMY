package n1exercise3;

import java.util.Arrays;
import java.util.List;

public class Main {
    static List<String> months = Arrays.asList("January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December");

    public static void main(String[] args) {
        months.forEach(month -> System.out.println(month));
    }
}
