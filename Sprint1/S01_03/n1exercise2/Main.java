package n1exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        List<Integer> reversed = new ArrayList<>();

        integers.add(1);
        integers.add(2);
        integers.add(3);

        System.out.println("Original list: " + integers);

        ListIterator<Integer> iterate = integers.listIterator(integers.size());

        while (iterate.hasPrevious()) {
            reversed.add(iterate.previous());
        }

        System.out.println("Reversed list: " + reversed);
    }
}