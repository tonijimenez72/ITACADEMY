package n1exercise2;

import java.util.List;
import java.util.stream.Collectors;

public class StringHandler {

    public static List<String> filterStrings(List<String> stringList) {
        List<String> filteredStrings = stringList.stream()
                .filter(str -> str.contains("o"))
                .filter(str -> str.length() > 5)
                .collect(Collectors.toList());
        return filteredStrings;
    }
}