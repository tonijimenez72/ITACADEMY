package n1exercise3;

import java.io.*;
import java.util.Scanner;

public class Ranking {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static String rankingPath() {
        String result = "/" + (System.getProperty("user.dir")).replace("\\", "/") + "/Sprint1/S01_03//src/main/bin/ranking.txt";
        return result;
    }

    public static void writeRanking(String username, int score) {
        String rankingFile = rankingPath();

        try (PrintWriter writer = new PrintWriter(new FileWriter(rankingFile, true))) {
            writer.println(username + ": " + score + " gallifantes.");
        } catch (IOException e) {
            System.out.println(ANSI_RED + "Oh, oh... Error saving the Score!" + ANSI_RESET);
        }
    }

    public static String getRanking() {
        String filename = rankingPath();
        String result = "";

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                //line = scanner.nextLine();
                result += scanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "GAME SCORES\n"
                + result;
    }
}