package n3exercise1;

public class Student {
    private String name;
    private int age;
    private String course;
    private int score;

    public Student(String name, int age, String course, int score) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.score = score;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getScore() {
        return score;
    }
    public String getCourse() {
        return course;
    }
}