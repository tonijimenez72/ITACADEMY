package n3exercise1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IOMenuMethods {
    public static final DecimalFormat twoDecimals = new DecimalFormat("#,##0.00");
    static ArrayList<Journalist> journalists = new ArrayList<>();
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    Scanner scanner = new Scanner(System.in);
    int numCode = -1;
    int journalistCode = -1;
    int newsCode = -1;
    int sportsCode = -1;
    String name;
    String idCard;
    String result = "";
    String headline = "";
    String competition = "";
    String team = "";
    String player = "";

    // Switch
    public void Switch(Scanner scanner){
        do {
            System.out.println(mainMenu());
            numCode = numCode(this.scanner);
            switch (numCode) {
                case 0:
                    result = "Closing application.";
                    break;
                case 1:
                    System.out.println(ANSI_GREEN + "Adding a new journalist." + ANSI_RESET + "\n"
                            + "Input name:");
                    name = this.scanner.nextLine();
                    System.out.println("Input DNI:");
                    idCard = this.scanner.next();
                    if (checkIdCard(idCard)){
                        result = ANSI_RED + "Invalid DNI." + ANSI_RESET + " Code already registered.\n";
                    }else{
                        result = addJournalist(name, idCard);
                    }

                    break;
                case 2:
                    System.out.println(ANSI_GREEN + "Unregistering journalist." + ANSI_RESET + "\n"
                            + getJournalistsList() + "Select journalist by number code:");
                    journalistCode = numCode(this.scanner);
                    if (journalistCode < 1 || (journalistCode > journalists.size())) {
                        result = checkJournalist(journalistCode);
                    }else {
                        result = delJournalist(journalistCode);
                    }
                    break;
                case 3:
                    System.out.println(ANSI_GREEN + "Assigning news to journalist." + ANSI_RESET + "\n"
                            + getJournalistsList() + "Select journalist by number code:");
                    journalistCode = numCode(this.scanner);
                    if (journalistCode < 1 || (journalistCode > journalists.size())) {
                        result = checkJournalist( journalistCode);
                    }else {
                        System.out.println("Write the headline:");
                        headline = this.scanner.nextLine();

                        System.out.println(sportsMenu());
                        sportsCode = numCode(this.scanner);

                        switch (sportsCode) {
                            case 1:
                                System.out.println("Tag Competition:");
                                competition = this.scanner.nextLine();
                                System.out.println("Tag Team:");
                                team = this.scanner.nextLine();
                                System.out.println("Tag Player:");
                                player = this.scanner.nextLine();
                                result = assignSoccerNews(journalistCode, headline, competition, team, player);
                                break;
                            case 2:
                                System.out.println("Tag Competition:");
                                competition = this.scanner.nextLine();
                                System.out.println("Tag Team:");
                                team = this.scanner.nextLine();
                                result = assignBasketballNews(journalistCode, headline, competition, team);
                                break;
                            case 3:
                                System.out.println("Tag Player:");
                                result = assignTennisNews(journalistCode, headline, player);
                                break;
                            case 4:
                                System.out.println("Tag Team:");
                                team = this.scanner.nextLine();
                                result = assignF1News(journalistCode, headline, team);
                                break;
                            case 5:
                                System.out.println("Tag Team:");
                                team = this.scanner.nextLine();
                                result = assignBikeNews(journalistCode, headline, team);
                                break;
                            case -2:
                                result = ANSI_RED + "Invalid number code." + ANSI_RESET + " Please, try again.";
                                break;
                            default:
                                result = ANSI_RED + "Invalid number code." + ANSI_RESET + " Please, try again.";
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println(ANSI_GREEN + "Deleting news by journalist." + ANSI_RESET
                            + getJournalistsList() + "Select journalist by number code:");
                    journalistCode = numCode(this.scanner);
                    if (journalistCode < 1 || (journalistCode > journalists.size())) {
                        result = checkJournalist(journalistCode);
                    }else {
                        System.out.println(getNewsByJournalist(journalistCode)
                                + "Select news to delete by number code:");
                        newsCode = numCode(this.scanner);
                        result = deleteNewsByJournalist(journalistCode, newsCode);
                    }
                    break;
                case 5: //List news by journalist
                    System.out.println(ANSI_GREEN + "Getting news by journalist." + ANSI_RESET + "\n"
                            + getJournalistsList() + "Select journalist by number code:");
                    journalistCode = numCode(this.scanner);
                    if (journalistCode < 1 || (journalistCode > journalists.size())) {
                        result = checkJournalist( journalistCode);
                    }else {
                        result = getNewsByJournalist(journalistCode);
                    }
                    break;
                case 6:
                    System.out.println(ANSI_GREEN + "Printing news sorted by Score." + ANSI_RESET + ".");
                    result =  getSortedByScore();
                    break;
                case 7:
                    System.out.println(ANSI_GREEN + "Printing news sorted by Price." + ANSI_RESET);
                    result = getSortedByPrice();
                    break;
                case -2:
                    result = ANSI_RED + "Invalid number code." + ANSI_RESET + " Please, try again.";
                    break;
                default:
                    result = ANSI_RED + "Invalid number code. " + ANSI_RESET + "Please, try again." + ANSI_RESET;
                    break;
            }
            System.out.println(result);
        } while (numCode != 0);
    }


    // Main Menu
    public static String mainMenu(){
        String result = "Redaction Menu.\n"
                + " 1. Add journalist\n"
                + " 2. Delete journalist\n"
                + " 3. Assign news to journalist\n"
                + " 4. Delete news\n"
                + " 5. Get news by journalist\n"
                + " 6. Get news score\n"
                + " 7. Get news price\n"
                + " 0. Exit\n"
                + "Select an option by number code: ";
        return result;
    }

    //Sports Menu
    public static String sportsMenu(){
        String result = "Sports Menu.\n"
                + " 1. Soccer.\n"
                + " 2. Basket.\n"
                + " 3. Tennis.\n"
                + " 4. F1.\n"
                + " 5. Motorcycle Racing.\n"
                + "Select an option by number code: ";
        return result;
    }

    // get Journalist
    public static String getJournalist(){
        String result = getJournalist() + "\n"
                + "Select the journalist number code:";
        return result;
    }

    // Input numeric code
    public static int numCode(Scanner scanner){
        int numCode = -1;
        while (!scanner.hasNextInt()) {
            scanner.next();
            numCode = -2;
            return numCode;
        }
        numCode = scanner.nextInt();
        scanner.nextLine();
        return numCode;
    }

    //Add Journalist
    public static String addJournalist(String name, String idCard) {
        Journalist journalist;
        String result = "";

        journalist = new Journalist(name, idCard);
        journalists.add(journalist);
        return result =  ANSI_GREEN + journalist.getName() + ANSI_RESET + " is now our new journalist.\n"
                + "- DNI: " + journalist.getIdCard() + "\n"
                + "- Base Salary: " + twoDecimals.format(journalist.getBASESALARY()) + "\n";
    }

    // Del Journalist
    public static String delJournalist(int numCode) {
        int i = 0;
        String name = "";
        boolean registered = false;
        while (i < journalists.size() && !registered) {
            if (i == numCode - 1) {
                name = journalists.get(i).getName();
                journalists.remove(i);
                registered = true;
            }
            i++;
        }
        if (registered) {
            return ANSI_RED + "Journalist " + name + " has been unregistered. " + ANSI_RESET + "\n";
        } else {
            return "Not registered yet.\n";
        }
    }

    // Get Journalists List
    public static String getJournalistsList() {
        String result = "";
        if (journalists.size() < 1) {
            result = "There are no journalists registered yet.\n";
        } else {
            for (int i = 0; i < journalists.size(); i++) {
                result += " " + (i + 1) + ". " + journalists.get(i).getName() + ", DNI: " + journalists.get(i).getIdCard() + "\n";
            }
            result = "Our journalists:\n" + result;
        }
        return result;
    }

    //Check Journalist
    public static String checkJournalist(int numCode){
        String result = "";
        if (numCode < 1) {
            result = ANSI_RED + "Invalid Journalist number code." + ANSI_RESET+ "\n";
        } else {
            result = ANSI_RED + "Invalid Journalist number code:" + ANSI_RESET + " We have just " + journalists.size() + " journalist.\n";
        }
        return result;
    }

    // Check IdCard
    public static boolean checkIdCard(String idCard) {
        boolean result = false;
        for (Journalist journalist : journalists) {
            result = journalist.getIdCard().equals(idCard) ? true : false;
        }
        return result;
    }

    // Assign news
    public static String assignSoccerNews(int numCode, String headline, String competition, String team, String player){
        String result = "";
        Journalist journalist = journalists.get(numCode -1);
        Soccer soccer = new Soccer(journalist, headline, competition, team, player);
        journalist.getNewsByJournalist().add(soccer);
        result = ANSI_GREEN + headline + ANSI_RESET + " added to " + journalists.get(numCode -1).getName() + "'s News.\n";
        return result;
    }

    public static String assignBasketballNews(int numCode, String headline, String competition, String team){
        String result = "";
        Journalist journalist = journalists.get(numCode -1);
        Basketball basketball = new Basketball(journalist, headline, competition, team);
        journalist.getNewsByJournalist().add(basketball);
        result = ANSI_GREEN + headline + ANSI_RESET + " added to " + journalists.get(numCode -1).getName() + "'s News.\n";
        return result;
    }

    public static String assignTennisNews(int numCode, String headline, String player){
        String result = "";
        Journalist journalist = journalists.get(numCode -1);
        Tennis tennis = new Tennis(journalist, headline, player);
        journalist.getNewsByJournalist().add(tennis);
        result = ANSI_GREEN + headline + ANSI_RESET + " added to " + journalists.get(numCode -1).getName() + "'s News.\n";
        return result;
    }

    public static String assignF1News(int numCode, String headline, String team){
        String result = "";
        Journalist journalist = journalists.get(numCode -1);
        F1 f1 = new F1(journalist, headline, team);
        journalist.getNewsByJournalist().add(f1);
        result = ANSI_GREEN + headline + ANSI_RESET + " added to " + journalists.get(numCode -1).getName() + "'s News.\n";
        return result;
    }

    public static String assignBikeNews(int numCode, String headline, String team){
        String result = "";
        Journalist journalist = journalists.get(numCode -1);
        MotoRacing motoRacing = new MotoRacing(journalist, headline, team);
        journalist.getNewsByJournalist().add(motoRacing);
        result = ANSI_GREEN + headline + ANSI_RESET + " added to " + journalists.get(numCode -1).getName() + "'s News.\n";
        return result;
    }

    // Get news by journalist
    public static String getNewsByJournalist(int numCode){
        int i = 0;
        String result = " ";
        Journalist journalist = journalists.get(numCode - 1);
        ArrayList<News> newsList = journalist.getNewsByJournalist();
        if (newsList.isEmpty()) {
            return "No news found for journalist " + journalist.getName() + ".";
        }else
            result = "News by journalist " + journalist.getName() + ":\n";
        for (News news : newsList) {
            result +=  " " + ++i + ". " + news.getHeadline() + ". Rating: " + news.calculateScore() + ". Price: " + twoDecimals.format(news.calculatePrice()) + " €\n";
        }
        return result;
    }

    // Delete news by journalist
    public static String deleteNewsByJournalist(int journalistCode, int newsCode) {
        String result = "";
        Journalist journalist = journalists.get(journalistCode - 1);
        ArrayList<News> newsList = journalist.getNewsByJournalist();
        if (newsList.isEmpty()) {
            result = "No news found for journalist " + journalist.getName() + ".";
        } else if (newsCode < 1 || newsCode > newsList.size()) {
            result = ANSI_RED + "Invalid news number code." + ANSI_RESET ;
        } else {
            News removedNews = newsList.remove(newsCode - 1);
            result = ANSI_RED + removedNews.getHeadline() + ANSI_RESET + " has been deleted. Writed by " + journalist.getName() + ".\n";
        }
        return result;
    }

    //All News Array
    public static ArrayList<News> allNewsArray() {
        ArrayList<News> allNewsArray = new ArrayList<>();
        for (Journalist journalist : journalists) {
            allNewsArray.addAll(journalist.getNewsByJournalist());
        }
        return allNewsArray;
    }

    // Score sorting
    public static ArrayList<News> scoreSorting(ArrayList<News> allNewsArray) {
        for (int i = 0; i < allNewsArray.size() - 1; i++) {
            for (int j = 0; j < allNewsArray.size() - i - 1; j++) {
                if (allNewsArray.get(j).calculateScore() < allNewsArray.get(j + 1).calculateScore()) {
                    Collections.swap(allNewsArray, j, j + 1);
                }
            }
        }
        return allNewsArray;
    }

    // Price sorting
    public static ArrayList<News> priceSorting(ArrayList<News> allNewsArray) {
        for (int i = 0; i < allNewsArray.size() - 1; i++) {
            for (int j = 0; j < allNewsArray.size() - i - 1; j++) {
                if (allNewsArray.get(j).calculatePrice() < allNewsArray.get(j + 1).calculatePrice()) {
                    Collections.swap(allNewsArray, j, j + 1);
                }
            }
        }
        return allNewsArray;
    }

    // Get news sorted by score
    public static String getSortedByScore() {
        int score = 0;
        String result = "";
        ArrayList<News> allNewsByScore = allNewsArray();
        ArrayList<News> allNewsArray = scoreSorting(allNewsByScore);
        for (News news : allNewsArray) {
            score = news.calculateScore();
            Journalist journalist = news.getJournalist();
            result += "Rating: " + score + " - " + news.getHeadline() + " - "
                    + "Journalist: " +  journalist.getName() + "\n";
        }
        return result + ANSI_YELLOW + "(Sorted with Collections Class in 'scoreSorting' method.)\n" + ANSI_RESET;
    }

    // Get news sorted by price
    public static String getSortedByPrice() {
        double price = 0D;
        String result = "";
        ArrayList<News> allNewsByPrice = allNewsArray();
        ArrayList<News> allNewsArray = priceSorting(allNewsByPrice);
        for (News news : allNewsArray) {
            price = news.calculatePrice();
            Journalist journalist = news.getJournalist();
            result += twoDecimals.format(price) + " €  - " + news.getHeadline() + " - " + "Journalist: " +  journalist.getName() + "\n";
        }
        return result + ANSI_YELLOW + "(Sorted with Collections Class in 'priceSorting' method.)\n" + ANSI_RESET;
    }
}
