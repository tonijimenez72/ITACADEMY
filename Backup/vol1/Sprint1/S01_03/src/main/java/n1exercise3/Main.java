package n1exercise3;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {

        int score;

        System.out.println(System.getProperty("user.dir"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Please, enter your name:");

        String player = scanner.nextLine();

        if (player.isEmpty()) {
            player = "Jane Doe";
        }

        System.out.println(ANSI_GREEN + "Ready player one.\n" + ANSI_RESET);

        HashMap<String, String> countriesMap = Countries.readCountries();

        Game game = new Game(countriesMap);

        score = game.play();

        Ranking.writeRanking(player, score);

        System.out.println(Ranking.getRanking());
    }
}
