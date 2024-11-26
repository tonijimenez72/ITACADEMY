package n1exercise8;

public class ReverseString {
    private final ReverseStringFI reverser;

    public ReverseString() {
        this.reverser = input -> new StringBuilder(input).reverse().toString();
    }

    public String getReversedString(String original) {
        return reverser.reverse(original);
    }
}