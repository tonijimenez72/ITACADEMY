package n2exercise4;

import java.util.ArrayList;
import java.util.List;

public class PlayWithStrings {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void performOperations() {
        List<String> list = new ArrayList<>();
        list.add("Ready");
        list.add("Steady");
        list.add("Go");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        list.sort((s1, s2) -> s1.charAt(0) - s2.charAt(0));
        System.out.println(ANSI_GREEN + "Sorted alphabetically by the first character:" + ANSI_RESET);
        System.out.println(list);

        list.sort((s1, s2) -> {
            if (s1.contains("e") && !s2.contains("e")) {
                return -1;
            } else if (!s1.contains("e") && s2.contains("e")) {
                return 1;
            } else {
                return 0;
            }
        });
        System.out.println(ANSI_GREEN + "\nStrings containing 'e' sorted first:" + ANSI_RESET);
        System.out.println(list);

        list.replaceAll(s -> s.replace("a", "4"));
        System.out.println(ANSI_GREEN + "\nList with elements modified to replace 'a' with '4':" + ANSI_RESET);
        System.out.println(list);

        System.out.println(ANSI_GREEN + "\nNumeric elements in the list:" + ANSI_RESET);
        list.stream()
                .filter(s -> s.matches("\\d+")) // filter numeric elements
                .forEach(System.out::println);
    }
}
