package n1exercise8;

public class Main {
    public static void main(String[] args) {
        ReverseString reverseStringInstance = new ReverseString();
        String original = "robert";

        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reverseStringInstance.getReversedString(original));
    }
}