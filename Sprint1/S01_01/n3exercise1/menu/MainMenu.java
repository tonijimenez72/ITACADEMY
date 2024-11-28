package n3exercise1.menu;

import n3exercise1.management.*;
import n3exercise1.sampleData.SampleData;

import java.util.Scanner;

public class MainMenu {
    static Scanner scanner = new Scanner(System.in);

    public void run() {
        int option;
        JournalistManagement journalistManagement = new JournalistManagement();
        NewsManagement newsManagement = new NewsManagement();
        SampleData sampleData = new SampleData();

        do {
            showMenu();

            option = InputManagement.inputOption();

            switch (option) {
                case 1 -> journalistManagement.createJournalist();
                case 2 -> journalistManagement.deleteJournalist();
                case 3 -> SportsMenu.run();
                case 4 -> NewsManagement.deleteNewsByJournalist();
                case 5 -> InfoManagement.getNewsByJournalist();
                case 6 -> InfoManagement.getNewsPrice();
                case 7 -> InfoManagement.getNewsScore();
                case 10 -> journalistManagement.readJournalists();
                case 11 -> System.out.println(journalistManagement.getJournalistIndex(InputManagement.inputIdCard()));
                case 12 -> InfoManagement.getAllNews();
                case 99 -> sampleData.run();
                case 0 -> System.out.println("Bye!");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);

        scanner.close();
    }

    private void showMenu() {
        String menu = """
        \nMain Menu
         99. Add sample data
         1. Create journalist
         2. Delete journalist
         3. Assign news to journalist
         4. Delete news
         5. Get news by journalist
         6. Get news score
         7. Get news price
         0. Exit
        """;
        System.out.print(menu);
    }

}