package n1exercise2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("difficult", "roads", "often", "lead", "to", "lovely", "destinations");

        List<String> result = hasOBiggestThan5(strings);
        System.out.println(result);
    }

    public static List<String> hasOBiggestThan5(List<String> strings) {
        return strings.stream()
                .filter(isO5 -> isO5.toLowerCase().contains("o") && isO5.length() > 5)
                .collect(Collectors.toList());
    }
}