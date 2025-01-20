package n1exercise1.controller;

import n1exercise1.model.Undo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private int option = 0;

    public void run() {
        Undo undo = Undo.getInstance();

        do {
            printMainMenu();
            try {
                option = scanner.nextInt();
                scanner.nextLine();

                switchMainMenu(undo);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        } while (option != 4);
        scanner.close();
    }

    private void switchMainMenu(Undo undo) {
        switch (option) {
            case 1 -> addCommand(undo);
            case 2 -> printCommandHistory(undo);
            case 3 -> deleteLastCommand(undo);
            case 4 -> System.out.println("Bye!");
            default -> System.out.println("Invalid number code. Please, try again.");
        }
    }

    private static void printMainMenu() {
            String menu =  """
               \nUndo menu
                1. Add new command
                2. List command history
                3. Delete last command
                4. Exit undo
               Select an option:
               """;
            System.out.println(menu);
        }

    private void addCommand(Undo undo) {
        String command;
        System.out.println("Adding new command:");
        command = scanner.nextLine();
        undo.addCommand(command);
    }

    private static void printCommandHistory(Undo undo) {
        if (undo.listCommandHistory().isEmpty()) {
            System.out.println("Command history is empty.");
        } else {
            System.out.println("Listing command history:");
            for (String commands : undo.listCommandHistory()) {
                System.out.println(commands);
            }
        }
    }

    private static void deleteLastCommand(Undo undo) {
        if (undo.listCommandHistory().isEmpty()) {
            System.out.println("Command history is empty.");
        } else {
            undo.removeLastCommand();
            System.out.println("Last command deleted.");
        }
    }
}
