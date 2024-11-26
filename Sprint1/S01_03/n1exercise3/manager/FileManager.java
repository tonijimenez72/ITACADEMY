package n1exercise3.manager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    private static final String COUNTRIES_FILE_PATH = "Sprint1" + File.separator + "S01_03" + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "n1exercise3" + File.separator + "resources" + File.separator + "countries.txt";
    private static final String RANKING_FILE_PATH = "Sprint1" + File.separator + "S01_03" + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "n1exercise3" + File.separator + "resources" + File.separator + "ranking.txt";

    public static List<String> readCountries() {
        List<String> countriesList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(COUNTRIES_FILE_PATH))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    countriesList.add(parts[0]);
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Countries file not found: " + COUNTRIES_FILE_PATH);
        }
        return countriesList;
    }

    public static List<String> readCapitals() {
        List<String> capitalsList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(COUNTRIES_FILE_PATH))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    capitalsList.add(parts[1]);
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Countries file not found: " + COUNTRIES_FILE_PATH);
        }
        return capitalsList;
    }

    public static void writeRanking(String username, int score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RANKING_FILE_PATH, true))) {
            writer.println(username + ": " + score);
        } catch (IOException e) {
            System.out.println("Error saving the ranking.");
            e.printStackTrace();
        }
    }

    public static String getRanking() {
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(RANKING_FILE_PATH))) {
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine()).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Ranking file not found: " + RANKING_FILE_PATH);
        }
        return "GAME SCORES\n" + result.toString();
    }
}