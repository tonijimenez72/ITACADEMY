package n1exercise1.exception;

public class EmptySaleException extends Exception {
    public EmptySaleException() {
        super("To make a sale, add products first.");
    }
}