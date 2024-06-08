package n1exercise1;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class GetPath {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void simpleLs(String[] args) {
        String readPath = "";

        readPath = checkParameter(args);
        String result = getChildItems(readPath);
        System.out.println(result);
    }

    public static String checkParameter(String[] args) {
        String path = "";
        if (args.length > 0) {
            path = args[0];
        } else {
            Scanner scanner = new Scanner(System.in);
            while (path.isEmpty()) {
                System.out.println("Path not provided as parameter\n"
                        + "Please, enter a valid path (example: C:/Test):");
                path = scanner.nextLine();
            }
        }
        return path;
    }

    public static String formatPath(String path) {
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System: " + os);
        if (!path.startsWith("\"") && !path.endsWith("\"")) {
            path = "\"" + path + "\"";
        }
        return path;
    }

    public static String getChildItems(String path) {
        String result = "";

        try{
            File directory = new File(path);

            if (!directory.exists()) {
                result = ANSI_CYAN + path + ":" + ANSI_RESET + ANSI_YELLOW + " unknow path." + ANSI_RESET;
            } else if (!directory.isDirectory()) {
                result = ANSI_CYAN + path  + ":" + ANSI_RESET + ANSI_YELLOW +" is a file." + ANSI_RESET;
            } else {
                File[] files = directory.listFiles();
                if (files == null || files.length == 0) {
                    result = ANSI_CYAN + path + ANSI_RESET + ":" + ANSI_YELLOW + " empty path." + ANSI_RESET;
                } else {
                    Arrays.sort(files);
                    for (File file : files) {
                        result += file.getName() + "\n";
                    }
                    result = ANSI_CYAN + path + ":\n" + ANSI_RESET + result;
                }
            }
        }catch(Exception e){
            System.out.println(ANSI_CYAN + path + ". " + ANSI_RESET + ANSI_YELLOW + "Unexpected error: " + ANSI_RESET + "Commander, signal the following in all languages and in all frequencies: 'We surrender'.");
        }
        return result;
    }
}