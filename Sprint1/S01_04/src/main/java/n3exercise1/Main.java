package n3exercise1;

public class Main {
    public static void main(String[] args) {
        Integer num1 = 5;
        Integer num2 = 10;
        Integer num3 = 5;

        assert num1.equals(num3) : "Equals.";
        assert !num1.equals(num2) : "Not equals.";
    }
}
