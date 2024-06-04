package n1exercise3;

import java.io.*;
import java.util.Scanner;

public class Ranking {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static final String[] FILE_PATHS = {"Sprint1/S01_03/src/main/bin/ranking.txt","resources/ranking.txt"};
    private static String filePath;

    static {
        setFilePath();
        ensureFileExists();
    }

    private static void setFilePath() {
        for (String path : FILE_PATHS) {
            File file = new File(path);
            if (file.exists()) {
                filePath = path;
                return;
            }
        }
        filePath = FILE_PATHS[0];  // Default to the first path if none exist
    }

    private static void ensureFileExists() {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Error creating file: " + filePath, e);
            }
        }
    }

    public static void writeRanking(String username, int score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(username + ": " + score + " gallifantes.");
        } catch (IOException e) {
            System.out.println(ANSI_RED + "Oh, oh... Error saving the Score!" + ANSI_RESET);
            e.printStackTrace();
        }
    }

    public static String getRanking() {
        StringBuilder result = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println(ANSI_RED + "Oh, oh... Ranking file not found!" + ANSI_RESET);
            e.printStackTrace();
        }
        return "GAME SCORES\n" + result.toString();
    }
}