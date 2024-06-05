package n1exercise7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GetList {
    private static List<Object> list = Arrays.asList(1, "go", 2, "Steady", 3, "Ready", 4);

    public static List<String> getListByLength() {
        return list.stream()
                .filter(String.class::isInstance)
                .map(Object::toString)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
    }
}