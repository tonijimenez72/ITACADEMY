package cat.itacademy.s04.t02.n03.exception;

public class FruitAlreadyExistsException extends RuntimeException {
    public FruitAlreadyExistsException(String message){
        super(message);
    }
}