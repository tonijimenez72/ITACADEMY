package n2exercise1;

public class StringLengthMatcher {
    private String string;
    private int length;

    public StringLengthMatcher(String string, int length) {
        this.string = string;
        this.length = length;
    }

    public String getString() {
        return string;
    }
    public int getLength() {
        return length;
    }
}