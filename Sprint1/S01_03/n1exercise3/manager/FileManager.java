package n1exercise3.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;

public class FileManager {

    private static final String[] COUNTRY_FILE_PATHS = {
            "Sprint1" + File.separator + "S01_03" + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "n1exercise3" + File.separator + "resources" + File.separator + "countries.txt",
            "resources" + File.separator + "countries.txt"
    };

    private static final String[] RANKING_FILE_PATHS = {
            "Sprint1" + File.separator + "S01_03" + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "n1exercise3" + File.separator + "resources" + File.separator + "ranking.txt",
            "resources" + File.separator + "ranking.txt"
    };

    private static String countriesFilePath;
    private static String rankingFilePath;

    static {
        setFilePaths();
        ensureRankingFileExists();
    }

    private static void setFilePaths() {
        countriesFilePath = getValidFilePath(COUNTRY_FILE_PATHS);
        rankingFilePath = getValidFilePath(RANKING_FILE_PATHS);
    }

    private static String getValidFilePath(String[] filePaths) {
        for (String path : filePaths) {
            File file = new File(path);
            if (file.exists()) {
                return path;
            }
        }
        throw new RuntimeException("No valid file path found.");
    }

    private static void ensureRankingFileExists() {
        File file = new File(rankingFilePath);
        if (!file.exists()) {
            createFileAndDirectories(file);
        }
    }

    private static void createFileAndDirectories(File file) {
        try {
            file.getParentFile().mkdirs();
            System.out.println(file.createNewFile() ?
                    "Ranking file created: " + file.getAbsolutePath() :
                    "File already exists: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error creating the ranking file.");
            e.printStackTrace();
        }
    }

    public static HashMap<String, String> readCountries() {
        HashMap<String, String> countriesMap = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(countriesFilePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    countriesMap.put(parts[0], parts[1]);
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Countries file not found: " + countriesFilePath);
        }
        return countriesMap;
    }

    public static void writeRanking(String username, int score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(rankingFilePath, true))) {
            writer.println(username + ": " + score);
        } catch (IOException e) {
            System.out.println("Error saving the ranking.");
            e.printStackTrace();
        }
    }

    public static String getRanking() {
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(rankingFilePath))) {
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ranking file not found: " + rankingFilePath);
        }
        return "GAME SCORES\n" + result.toString();
    }
}