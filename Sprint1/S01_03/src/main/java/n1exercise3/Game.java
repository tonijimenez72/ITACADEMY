package n1exercise3;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    private HashMap<String, String> countriesMap;

    public Game(HashMap<String, String> countriesMap) {
        this.countriesMap = countriesMap;
    }

    public int play() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < 10; i++) {
            String randomCountry = getRandomCountry();
            String capital = countriesMap.get(randomCountry);

            System.out.println("What's the capital of " + randomCountry + "?");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(capital)) {
                System.out.println(ANSI_GREEN + "Well done!" + ANSI_RESET);
                score++;
            } else {
                System.out.println(ANSI_YELLOW + "Wrong... The capital is " + capital + "." + ANSI_RESET);
            }
        }

        System.out.println("GAME OVER. Your score is: " + score + " gallifantes.\n");
        return score;
    }

    private String getRandomCountry() {
        Object[] countriesArray = countriesMap.keySet().toArray();
        Random random = new Random();
        int randomIndex = random.nextInt(countriesArray.length);
        return (String) countriesArray[randomIndex];
    }
}
