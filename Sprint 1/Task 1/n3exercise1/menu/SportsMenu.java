package n3exercise1.menu;

import n3exercise1.management.*;

import java.util.Scanner;

public class SportsMenu {
    public static void run() {
        int option;
        Scanner scanner = new Scanner(System.in);
        NewsManagement newsManagement = new NewsManagement();

        do {
            showMenu();

            option = InputManagement.inputOption();

            switch (option) {
                case 1 -> newsManagement.assignBasketNews();
                case 2 -> newsManagement.assignF1News();
                case 3 -> newsManagement.assignMotoNews();
                case 4 -> newsManagement.assignSoccerNews();
                case 5 -> newsManagement.assignTennisNews();
                case 0 -> System.out.println("Back to Main Menu.");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);

    }

    private static void showMenu() {
        String menu = """
        \nSports Menu
         1. Basketball
         2. F1
         3. Moto Racing
         4. Soccer
         5. Tennis
         0. Exit
        """;
        System.out.print(menu);
    }
}
