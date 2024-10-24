package n3exercise1;

public class Exceptions {
    static class InvalidPersonNameException extends Exception {
        public InvalidPersonNameException(String message) {
            super(message);
        }
    }

    static class InvalidRowException extends Exception {
        public InvalidRowException(String message) {
            super(message);
        }
    }

    static class InvalidSeatNumberException extends Exception {
        public InvalidSeatNumberException(String message) {
            super(message);
        }
    }

    static class SeatIsReservedException extends Exception {
        public SeatIsReservedException(String message) {
            super(message);
        }
    }

    static class SeatNotReservedException extends Exception {
        public SeatNotReservedException(String message) {
            super(message);
        }
    }

    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }

    public static byte validateInputByte(byte value, int min, int max) throws InvalidInputException {
        if (value < min || value > max) {
            throw new InvalidInputException("Invalid input. Please enter a value between " + min + " and " + max + ".");
        }
        return value;
    }
}