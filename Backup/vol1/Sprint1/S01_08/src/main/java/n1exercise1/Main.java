package n1exercise1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("who", "perseveres", "succeeds");

        List<String> result = hasOMethod(strings);
        System.out.println(result);
    }

    public static List<String> hasOMethod(List<String> strings) {
        return strings.stream()
                .filter(has0 -> has0.toLowerCase().contains("o"))
                .collect(Collectors.toList());
    }
}
