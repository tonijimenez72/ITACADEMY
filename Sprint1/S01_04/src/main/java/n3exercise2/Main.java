package n3exercise2;

public class Main {
    public static void main(String[] args) {
        Integer num1 = new Integer(5);
        Integer num2 = num1;
        Integer num3 = new Integer(5);

        assert num1 == num2 : "Equals.";
        assert num1 != num3 : "Not equals.";
    }
}
