package n1exercise1;

public class EmptySaleException extends Exception {
    public EmptySaleException(){
        super("REMEMBER: To make a sale, you must first add products.");
    }
}