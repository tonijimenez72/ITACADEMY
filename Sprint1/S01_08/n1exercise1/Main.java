package n1exercise1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> vehicles = Arrays.asList("o", "a", "OO", "b",
                "Ooo");

        System.out.println(StringHandler.filterStrings(vehicles));
    }
}
