package n2exercise2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        String result = NewString.generateString(numbers);
        System.out.println(result);
    }
}
