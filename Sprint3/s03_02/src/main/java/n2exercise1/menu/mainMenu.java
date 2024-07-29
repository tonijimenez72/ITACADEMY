package n2exercise1.menu;

import n2exercise1.observer.*;

import java.util.Scanner;

public class mainMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static StockMarketAgent agent = new StockMarketAgent();

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        int option = -1;

        do {
            printMainMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addAgency();
                    showTotalAgencies();
                    break;
                case 2:
                    showAgencies();
                    break;
                case 3:
                    notifyIncrease();
                    break;
                case 4:
                    notifyDecrease();
                    break;
                case 5:
                    removeAgency();
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 0);
    }

    private static void printMainMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add Agency");
        System.out.println("2. Show Agencies");
        System.out.println("3. Increase Stock Value");
        System.out.println("4. Decrease Stock Value");
        System.out.println("5. Remove Agency");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addAgency() {
        System.out.print("Enter agency name: ");
        String name = scanner.nextLine();
        StockMarketAgency agency = new StockMarketAgency(name);
        agent.addObserver(agency);
    }

    private static void showTotalAgencies() {
        System.out.println("Total agencies: " + agent.getAgencies().size());
    }

    private static void showAgencies() {
        System.out.println("Agencies:");
        for (StockMarketAgency agency : agent.getAgencies()) {
            System.out.println("- " + agency.getName());
        }
    }

    private static void notifyIncrease() {
        agent.notifyValueUp();
    }

    private static void notifyDecrease() {
        agent.notifyValueDown();
    }

    private static void removeAgency() {
        showAgencies();
        System.out.print("Enter the name of the agency to remove: ");
        String name = scanner.nextLine();
        StockMarketAgency agencyToRemove = null;
        for (StockMarketAgency agency : agent.getAgencies()) {
            if (agency.getName().equals(name)) {
                agencyToRemove = agency;
                break;
            }
        }
        if (agencyToRemove != null) {
            agent.removeObserver(agencyToRemove);
            System.out.println("Agency " + name + " removed.");
        } else {
            System.out.println("Agency not found.");
        }
    }
}