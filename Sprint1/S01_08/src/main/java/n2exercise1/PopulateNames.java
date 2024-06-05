package n2exercise1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PopulateNames {
    private List<String> names;

    public PopulateNames() {
        this.names = Arrays.asList("David", "Ava", "Joy", "Anna", "Sid", "Jim", "Ale");
    }

    public List<String> AStartsAndThreeLetters() {
        return names.stream()
                .filter(name -> name.length() == 3 && name.startsWith("A"))
                .collect(Collectors.toList());
    }
}
