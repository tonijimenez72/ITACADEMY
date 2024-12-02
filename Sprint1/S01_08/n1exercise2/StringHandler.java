package n1exercise2;

import java.util.List;
import java.util.stream.Collectors;

public class StringHandler {

    public static List<String> filterStrings(List<String> stringList) {
        return stringList.stream()
                .filter(str -> str.toLowerCase().contains("o") && str.length() > 5)
                .collect(Collectors.toList());
    }
}