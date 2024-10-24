package n1exercise3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Countries {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static final String[] FILE_PATHS = {"Sprint1/S01_03/src/main/java/n1exercise3/resources/countries.txt", "resources/countries.txt"};
    private static String filePath;

    public static HashMap<String, String> readCountries() {
        HashMap<String, String> countriesMap = new HashMap<>();
        setFilePath();

        try (Scanner scanner = new Scanner(new File(filePath))) {
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
            System.out.println("Seems that someone stole our countries.txt...\n"
                    + ANSI_RED + "Missing: " + ANSI_RESET + filePath);
        }
        return countriesMap;
    }

    private static void setFilePath() {
        for (String path : FILE_PATHS) {
            File file = new File(path);
            if (file.exists()) {
                filePath = path;
                return;
            }
        }
        throw new RuntimeException("No valid file path found.");
    }
}