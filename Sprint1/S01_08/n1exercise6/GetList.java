package n1exercise6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GetList {
    private static List<Object> list = Arrays.asList("put", 2, "and", 2, "together");

    public static List<String> getListByLength(List<Object> list) {
        return list.stream()
                .filter(String.class::isInstance)
                .map(Object::toString)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}