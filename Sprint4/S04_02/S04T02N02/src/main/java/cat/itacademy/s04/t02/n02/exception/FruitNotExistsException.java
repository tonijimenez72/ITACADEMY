package cat.itacademy.s04.t02.n02.exception;

public class FruitNotExistsException extends RuntimeException {
    public FruitNotExistsException(String message) {
        super(message);
    }
}