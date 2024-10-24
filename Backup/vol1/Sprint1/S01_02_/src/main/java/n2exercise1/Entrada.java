package n2exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
    static Scanner input = new Scanner(System.in);

    public static byte readByte(String message) {
        boolean isOk = false;
        byte value = 0;

        while (!isOk) {
            System.out.println(message);
            try {
                value = input.nextByte();
                isOk = true;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Ep, m'esperava un Byte.");
            }
        }
        return value;
    }

    public static int readInt(String message) {
        boolean isOk = false;
        int value = 0;

        while (!isOk) {
            System.out.println(message);
            try {
                value = input.nextInt();
                isOk = true;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Ep, m'esperava un integer.");
            }
        }
        return value;
    }

    public static float readFloat(String message) {
        boolean isOk = false;
        float value = 0F;

        while (!isOk) {
            System.out.println(message);
            try {
                value = input.nextFloat();
                isOk = true;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Ep, m'esperava un float separat amb una coma.");
            }
        }
        return value;
    }

    public static double readDouble(String message) {
        boolean isOk = false;
        double value = 0D;

        while (!isOk) {
            System.out.println(message);
            try {
                value = input.nextDouble();
                isOk = true;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Ep, m'esperava un double separat amb una coma.");
            }
        }
        return value;
    }

    public static char readChar(String message) {
        boolean isOk = false;
        char value = ' ';

        while (!isOk) {
            System.out.println(message);
            try {
                String cInput = input.next().toUpperCase();
                if (cInput.length() != 1 || !Character.isLetter(cInput.charAt(0))) {
                    throw new Exception();
                } else {
                    value = cInput.charAt(0);
                    isOk = true;
                }
            } catch (Exception e) {
                input.nextLine();
                System.out.println("Ep, m'esperava un char en forma de lletra.");
            }
        }
        return value;
    }

    public static String readString(String message) {
        boolean isOk = false;
        String value = " ";

        while (!isOk) {
            System.out.println(message);
            try {
                value = input.next();
                if (value.isEmpty() || value.matches(".*\\d.*")) {
                    throw new Exception();
                } else {
                    value = value.toUpperCase();
                    isOk = true;
                }
            } catch (Exception e) {
                input.nextLine();
                System.out.println("Ep, m'esperava un String.");
            }
        }
        return value;
    }

    public static boolean readBoolean(String message) {
        boolean isOk = false;
        boolean value = false;

        while (!isOk) {
            System.out.println(message);
            String response = input.next().trim().toLowerCase();
            if (response.equals("s")) {
                value = true;
                isOk = true;
            } else if (response.equals("n")) {
                value = false;
                isOk = true;
            } else {
                input.nextLine();
                System.out.println("Ep, m'esperava una resposta 'S' o 'N'.");
            }
        }
        return value;
    }

    public static void closeScanner() {
        if (input != null) {
            input.close();
        }
    }
}