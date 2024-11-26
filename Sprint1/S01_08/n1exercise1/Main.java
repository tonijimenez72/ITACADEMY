package n1exercise1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> vehicles = Arrays.asList("o", "a", "oo", "b",
                "ooo");

        System.out.println(StringHandler.filterStrings(vehicles));
    }
}
