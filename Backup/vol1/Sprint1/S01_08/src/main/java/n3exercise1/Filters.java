package n3exercise1;

import java.util.List;
import java.util.stream.Collectors;

public class Filters {
    public static final String ANSI_RAMONE = "\u001B[38;5;205m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void applyAllFilters(List<Student> students) {
        showNameAndAge(students);

        List<Student> studentsWithNameStartingWithA = filterNameStartsWithA(students);
        System.out.println(ANSI_RAMONE + "\nStudents whose name starts with 'a':" + ANSI_RESET);
        studentsWithNameStartingWithA.forEach(student -> System.out.println(student.getName()));

        List<Student> studentsWithGrade5OrMore = filterGradeGreaterThanOrEqual5(students);
        System.out.println(ANSI_RAMONE + "\nStudents with grade 5 or more:" + ANSI_RESET);
        studentsWithGrade5OrMore.forEach(student -> System.out.println(student.getName() + ": " + student.getScore()));

        List<Student> studentsWithGrade5OrMoreNotPHP = filterGradeGreaterThanOrEqual5AndNotPHP(students);
        System.out.println(ANSI_RAMONE + "\nStudents with grade 5 or more and not studying PHP:" + ANSI_RESET);
        studentsWithGrade5OrMoreNotPHP.forEach(student -> System.out.println(student.getName() + ": " + student.getScore() + ", " + student.getCourse()));

        List<Student> studentsStudyingJavaAndAdults = filterJavaAndAdults(students);
        System.out.println(ANSI_RAMONE + "\nStudents studying Java and are adults:" + ANSI_RESET);
        studentsStudyingJavaAndAdults.forEach(student -> System.out.println(student.getName() + ": " + student.getAge()));
    }

    public static void showNameAndAge(List<Student> students) {
        System.out.println(ANSI_RAMONE + "Names and ages of students:" + ANSI_RESET);
        students.forEach(student -> System.out.println(student.getName() + ": " + student.getAge()));
    }

    public static List<Student> filterNameStartsWithA(List<Student> students) {
        return students.stream()
                .filter(student -> student.getName().toLowerCase().startsWith("a"))
                .collect(Collectors.toList());
    }

    public static List<Student> filterGradeGreaterThanOrEqual5(List<Student> students) {
        return students.stream()
                .filter(student -> student.getScore() >= 5)
                .collect(Collectors.toList());
    }

    public static List<Student> filterGradeGreaterThanOrEqual5AndNotPHP(List<Student> students) {
        return students.stream()
                .filter(student -> student.getScore() >= 5 && !student.getCourse().equalsIgnoreCase("PHP"))
                .collect(Collectors.toList());
    }

    public static List<Student> filterJavaAndAdults(List<Student> students) {
        return students.stream()
                .filter(student -> student.getCourse().equalsIgnoreCase("Java") && student.getAge() >= 18)
                .collect(Collectors.toList());
    }
}