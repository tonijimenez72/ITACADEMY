package n1exercise1;

import java.util.List;
import java.util.stream.Collectors;

public class StringHandler {

    public static List<String> filterStrings(List<String> stringList) {
        List<String> filteredStrings = stringList.stream()
                .filter(str -> str.contains("o"))
                .collect(Collectors.toList());
        return filteredStrings;
    }
}