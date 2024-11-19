package n3exercise1.management;

import java.util.Scanner;

public class InputManagement {
    static Scanner scanner = new Scanner(System.in);

    public static int inputOption() {
        int result;
        System.out.println("Select an option by number code: ");
        result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    public static String inputIdCard() {
        String result;
        System.out.println("Input DNI:");
        return scanner.nextLine();
    }

    public static String inputName() {
        System.out.println("Input name:");
        return scanner.nextLine();
    }

    public static String inputHeadline() {
        System.out.println("Input Headline:");
        return scanner.nextLine();
    }

    public static String inputBody() {
        System.out.println("Input Body:");
        return scanner.nextLine();
    }

    public static String inputCompetition() {
        System.out.println("Input Competition");
        return scanner.nextLine();
    }

    public static String inputTeam() {
        System.out.println("Input Team:");
        return scanner.nextLine();
    }

    public static String inputPlayer() {
        System.out.println("Input Player:");
        return scanner.nextLine();
    }
}
