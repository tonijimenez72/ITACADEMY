package n01exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IOMethods {

    private Scanner scanner = new Scanner(System.in);
    private int option = 0;

    public void menu() {
        Undo undo = Undo.getInstance();
        String command;
        String menuBlock =  """
               \nUndo menu
                1. Add new command
                2. List command history
                3. Delete last command
                4. Exit undo
               Select an option:
               """;

        do {
            System.out.println(menuBlock);
            try {
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("Adding new command:");
                        command = scanner.nextLine();
                        undo.addCommand(command);
                        break;
                    case 2:
                        if (undo.listCommandHistory().isEmpty()) {
                            System.out.println("Command history is empty.");
                        } else {
                            System.out.println("Listing command history:");
                            for (String commands : undo.listCommandHistory()) {
                                System.out.println(commands);
                            }
                        }
                        break;
                    case 3:
                        if (undo.listCommandHistory().isEmpty()) {
                            System.out.println("Command history is empty.");
                        } else {
                            System.out.println("Deleting last command:");
                            undo.removeLastCommand();
                        }

                        break;
                    case 4:
                        System.out.println("Bye!");
                        scanner.close();
                        break;
                    default:
                        System.out.println("Invalid number code. Please, try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        } while (option != 4);
    }
}