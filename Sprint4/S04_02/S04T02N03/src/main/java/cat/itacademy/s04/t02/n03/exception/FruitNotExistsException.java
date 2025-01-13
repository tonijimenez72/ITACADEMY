package cat.itacademy.s04.t02.n03.exception;

public class FruitNotExistsException extends RuntimeException {
    public FruitNotExistsException(String message) {
        super(message);
    }
}