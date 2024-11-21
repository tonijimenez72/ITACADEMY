package n1exercise1.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Manager {
    private ArrayList<String> months;
    private Set<String> monthsHashSet;
    private Set<String> monthsLinkedHashSet;

    public Manager(ArrayList<String> months, Set<String> monthsHashSet, Set<String> monthsLinkedHashSet) {
        this.months = months;
        this.monthsHashSet = monthsHashSet;
        this.monthsLinkedHashSet = monthsLinkedHashSet;
    }

    public void printArrayList() {
        System.out.println("Printing months ArrayList:");
        for (String month : months) {
            System.out.print(month + "\n");
        }
        System.out.println();
    }

    public void printHashSet() {
        System.out.println("\nPrinting months HashSet with 'for':");
        for (String month : monthsHashSet) {
            System.out.print(month + "\n");
        }
        System.out.println();
    }

    public void printLinkedHashSet() {
        System.out.println("\nPrinting months LinkedHashSet with 'for':");
        for (String month : monthsLinkedHashSet) {
            System.out.print(month + "\n");
        }
        System.out.println();
    }

    public void printLinkedHashSetWithIterator() {
        System.out.println("\nPrinting months LinkedHashSet with 'Iterator':");
        Iterator<String> iterator = monthsLinkedHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}