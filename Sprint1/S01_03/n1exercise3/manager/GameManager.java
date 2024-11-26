package n1exercise3.manager;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
    private static final Scanner scanner = new Scanner(System.in);
    private final List<String> countriesList;
    private final List<String> capitalsList;

    public GameManager() {
        this.countriesList = FileManager.readCountries();
        this.capitalsList = FileManager.readCapitals();
    }

    public void run() {
        String player = inputPlayerName();
        System.out.println("Welcome to the Country Capital game, " + player + ".");

        int score = play();
        FileManager.writeRanking(player, score);

        System.out.println(FileManager.getRanking());
    }

    private String inputPlayerName() {
        System.out.println("Welcome! Please, enter your name:");
        String player = scanner.nextLine();
        return player.isEmpty() ? "Jane Doe" : player;
    }

    private int play() {
        int score = 0;
        for (int i = 0; i < 10; i++) {
            int randomIndex = getRandomCountryIndex();
            String randomCountry = countriesList.get(randomIndex);
            String capital = capitalsList.get(randomIndex);
            String playerAnswer = askQuestion(randomCountry);

            score = checkAnswer(playerAnswer, capital, score);
        }

        System.out.println("GAME OVER. Your final score is: " + score + ".");
        return score;
    }

    private int getRandomCountryIndex() {
        Random random = new Random();
        return random.nextInt(countriesList.size());
    }

    private String askQuestion(String randomCountry) {
        System.out.println("What's the capital of " + randomCountry + "?");
        return scanner.nextLine();
    }

    private int checkAnswer(String playerAnswer, String capital, int score) {
        if (playerAnswer.equalsIgnoreCase(capital)) {
            score++;
            System.out.println("Well done, you win 1 point! Your score is: " + score + " points.");
        } else {
            System.out.println("Wrong... The capital is " + capital + ".");
        }
        return score;
    }
}