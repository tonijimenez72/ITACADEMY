package n1exercise2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("a", "ao", "b",
                "BOOOOO", "booooo");

        System.out.println(StringHandler.filterStrings(stringList));
    }
}
