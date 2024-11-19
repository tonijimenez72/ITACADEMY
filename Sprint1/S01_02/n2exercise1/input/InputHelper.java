package n2exercise1.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    private static Scanner input = new Scanner(System.in);

    public static byte readByte(String message) {
        return readInput(message, input -> {
            return input.nextByte();
        });
    }

    public static int readInt(String message) {
        return readInput(message, input -> {
            return input.nextInt();
        });
    }

    public static float readFloat(String message) {
        return readInput(message, input -> {
            return input.nextFloat();
        });
    }

    public static double readDouble(String message) {
        return readInput(message, input -> {
            return input.nextDouble();
        });
    }

    public static char readChar(String message) {
        return readInput(message, input -> {return checkChar(input);});
    }

    private static char checkChar(Scanner input) throws Exception {
        String response = input.next().toLowerCase();

        if (response.length() == 1 && Character.isLetter(response.charAt(0))) {
            return response.charAt(0);
        } else {
            throw new Exception("Invalid character input");
        }
    }

    public static String readString(String message) {
        return readInput(message, input -> {return checkString(input);});
    }

    private static String checkString(Scanner input) throws Exception {
        String response = input.next();

        if (response.isEmpty() || response.matches(".*\\d.*")) {
            throw new Exception("Invalid string input");
        }

        return response;
    }

    public static boolean readBoolean(String message) {
        return readInput(message, input -> {return checkBoolean(input);});
    }

    private static Boolean checkBoolean(Scanner input) throws Exception {
        String response = input.next().toLowerCase();

        if (response.equals("y")) {
            return true;
        } else if (response.equals("n")) {
            return false;
        } else {
            throw new Exception("Invalid input");
        }
    }

    public static void closeScanner() {
        if (input != null) {
            input.close();
        }
    }

    private interface InputParser<T> {
        T parse(Scanner input) throws Exception;
    }

    private static <T> T parseInput(InputParser<T> parser) {
        T value = null;
        try {
            value = parser.parse(input);
        } catch (InputMismatchException e) {
            input.nextLine();
            System.out.println("Invalid input. Please enter a valid value.");
        } catch (Exception e) {
            input.nextLine();
            System.out.println("An error occurred. Please try again.");
        }
        return value;
    }

    private static <T> T readInput(String message, InputParser<T> parser) {
        T value = null;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(message);
            value = parseInput(parser);
            if (value != null) {
                isValid = true;
            }
        }
        return value;
    }
}