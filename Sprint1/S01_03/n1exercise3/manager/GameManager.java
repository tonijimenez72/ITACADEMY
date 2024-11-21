package n1exercise3.manager;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
    private static final Scanner scanner = new Scanner(System.in);
    private HashMap<String, String> countriesMap;

    public GameManager() {
        this.countriesMap = FileManager.readCountries();
    }

    public void run() {
        int score;
        String player;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! Please, enter your name:");

        player = inputPlayerName();

        System.out.println("Welcome to the Country Capital game, " + player + ".");

        score = play(scanner);

        FileManager.writeRanking(player, score);

        System.out.println(FileManager.getRanking());
    }

    private String inputPlayerName() {
        String player = scanner.nextLine();
        return player.isEmpty() ? "Jane Doe" : player;
    }

    private int play(Scanner scanner) {
        int score = 0;
        for (int i = 0; i < 10; i++) {
            String randomCountry = getRandomCountry();
            String capital = countriesMap.get(randomCountry);
            String playerAnswer;

            System.out.println("What's the capital of " + randomCountry + "?");
            playerAnswer = scanner.nextLine();

            score = checkAnswer(playerAnswer, capital, score);
        }

        scanner.close();

        System.out.println("GAME OVER. Your score is: " + score + ".");

        return score;
    }

    private String getRandomCountry() {
        Object[] countriesArray = countriesMap.keySet().toArray();
        Random random = new Random();
        int randomIndex = random.nextInt(countriesArray.length);

        return (String) countriesArray[randomIndex];
    }

    private int checkAnswer(String playerAnswer, String capital, int score) {
        if (playerAnswer.equalsIgnoreCase(capital)) {
            score++;
            System.out.println("Well done, you win 1 point! Your score grows: " + score);
        } else {
            System.out.println("Wrong... The capital is " + capital + ".");
        }
        return score;
    }

}
