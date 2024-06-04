package n1exercise3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Countries {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static HashMap<String, String> readCountries() {
        HashMap<String, String> countriesMap = new HashMap<>();
        String countriesFile = countriesPath();

        try (Scanner scanner = new Scanner(new File(countriesFile))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                countriesMap.put(parts[0], parts[1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Seems that someone stole our countries.txt...\n"
                    + ANSI_RED + "Missing: " + ANSI_RESET + countriesFile);
        }
        return countriesMap;
    }

    private static String countriesPath() {

        String result = "/" + (System.getProperty("user.dir")).replace("\\", "/") + "/Sprint1/S01_03/src/main/bin/countries.txt";
        return result;
    }
}
