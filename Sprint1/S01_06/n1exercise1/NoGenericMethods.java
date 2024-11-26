package n1exercise1;

public class NoGenericMethods {
    private String first;
    private String second;
    private String third;

    public NoGenericMethods(String first, String second, String third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public String getThird() {
        return third;
    }

    @Override
    public String toString() {
        return "First: " + first + "\nSecond: " + second + "\nThird: " + third + "\n";
    }
}