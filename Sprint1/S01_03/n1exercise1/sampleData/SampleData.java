package n1exercise1.sampleData;

import n1exercise1.manager.Manager;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class SampleData {
    public Manager run() {
        ArrayList<String> months = new ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add(7, "August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");

        Set<String> monthsHashSet = new HashSet<>(months);
        Set<String> monthsLinkedHashSet = new LinkedHashSet<>(months);

        months.add("August");
        months.add("Antonier");

        monthsHashSet.add("August");
        monthsHashSet.add("Antonier");

        monthsLinkedHashSet.add("August");
        monthsLinkedHashSet.add("Antonier");

        return new Manager(months, monthsHashSet, monthsLinkedHashSet);
    }
}
