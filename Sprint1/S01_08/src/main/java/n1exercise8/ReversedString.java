package n1exercise8;

import n1exercise8.interfaces.ReverseStringFI;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReversedString {
    ReverseStringFI reverser = (input) -> IntStream.range(0, input.length())
            .mapToObj(i -> input.charAt(input.length() - i - 1))
            .map(String::valueOf)
            .collect(Collectors.joining());

    public String getReversedString(String original) {
        String reversed = reverser.reverse(original);
        return "Original: " + original + "\n"
                + "Reversed: " + reversed;
    }
}