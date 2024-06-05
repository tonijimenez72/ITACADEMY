package n2exercise1;

import java.io.IOException;
import java.util.Properties;

public class Main {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        try {
            Properties prop = GetPath.loadConfig();
            String path = GetPath.checkParameter(prop);

            System.out.println(GetPath.writeToFile(GetPath.getChildItemsRecursive(path)));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
