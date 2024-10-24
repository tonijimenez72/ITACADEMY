package n1exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        List<Integer> stni = new ArrayList<>();

        ints.add(1);
        ints.add(2);
        ints.add(3);
        System.out.println(ints);

        ListIterator<Integer> iterate = ints.listIterator();
        while (iterate.hasNext()) {
            stni.add(0, iterate.next());
        }
        System.out.println(stni);
    }
}
