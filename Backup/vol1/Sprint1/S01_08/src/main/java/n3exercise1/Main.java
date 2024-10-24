package n3exercise1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = PopulateTest.populate();
        Filters.applyAllFilters(students);
    }
}