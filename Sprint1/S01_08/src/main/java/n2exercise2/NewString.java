package n2exercise2;

import java.util.List;
import java.util.stream.Collectors;

public class NewString {
    public static String generateString(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> (number % 2 == 0 ? "e" : "o") + number)
                .collect(Collectors.joining(", "));
    }
}