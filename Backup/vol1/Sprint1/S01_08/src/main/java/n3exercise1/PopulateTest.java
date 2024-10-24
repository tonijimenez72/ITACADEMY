package n3exercise1;

import java.util.ArrayList;
import java.util.List;

public class PopulateTest {
    public static List<Student> populate() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("PJ Soles", 20, "Java", 6));
        students.add(new Student("Chris Somma", 22, "PHP", 4));
        students.add(new Student("Dey Young", 21, "Java", 7));
        students.add(new Student("Lynn Farrell", 19, "Java", 8));
        students.add(new Student("Terry Soda", 20, "Python", 7));
        students.add(new Student("Joey Ramone", 21, "PHP", 6));
        students.add(new Student("Johnny Ramone", 22, "Java", 9));
        students.add(new Student("Dee Dee Ramone", 20, "Python", 5));
        students.add(new Student("Marky Ramone", 21, "Java", 7));
        students.add(new Student("Al Capone", 21, "Java", 7));
        return students;
    }
}