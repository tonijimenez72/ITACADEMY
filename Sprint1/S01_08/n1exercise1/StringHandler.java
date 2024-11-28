package n1exercise1;

import java.util.List;
import java.util.stream.Collectors;

public class StringHandler {

    public static List<String> filterStrings(List<String> stringList) {
        return stringList.stream()
                .filter(str -> str.toLowerCase().contains("o"))
                .collect(Collectors.toList());
    }
}