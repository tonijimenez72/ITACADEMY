package scapeRoom.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    int numCode = -1;
    String result = "";
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        int numCode = - 1;

        do {

            try {
                System.out.println( "Scape Room Menu.\n"
                        + " 1. Add room\n"
                        + " 2. Add clue to room\n"
                        + " 3. Add decoration to room\n"
                        + " 4. Show inventory\n"
                        + " 5. Withdraw decoration\n"
                        + " 6. Show rooms\n"
                        + " 0. Exit\n"
                        + "Select an option by number code: ");
                numCode = scanner.nextInt();
                scanner.nextLine();

                switch (numCode) {
                    case 1:
                        addRoom();
                        break;
                    case 2:
                        // Add clue
                        break;
                    case 3:
                        // Add decoration
                        break;
                    case 4:
                        // Show inventory
                        break;
                    case 5:
                        // Withdraw decoration
                        break;
                    case 6:
                        // Show rooms
                        break;
                    case 0:
                        result = "Exit app.";
                        break;
                    default:
                        result = "Invalid number code. Please, try again.";
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid number code. Please, try again.");
                scanner.nextLine();
            }
            System.out.println(result);
        } while (numCode != 0);
    }

    public static void addRoom() {
        String name = "";
        String level = "";

    }
}
