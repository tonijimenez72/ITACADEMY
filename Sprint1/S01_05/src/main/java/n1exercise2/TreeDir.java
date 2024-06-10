package n1exercise2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class TreeDir {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static int depth = 0;

    public static void recursiveLs(String[] args) {
        String readPath = "";

        readPath = checkParameter(args);
        String result = getChildItemsRecursive(readPath);
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
            scanner.close();
        }
        return path;
    }

    public static String formatPath(String path) {
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System: " + os);
        path = path.replace("\"", "");
        return path;
    }

    public static String getChildItemsRecursive(String path) {
        String result = "";

        path = path.replace("/", File.separator).replace("\\", File.separator);
        try{
            File directory = new File(path);

            if (!directory.exists()) {
                result += indent() + ANSI_YELLOW + path + ": " + ANSI_RESET + "unknown path." + "\n";
            } else if (!directory.isDirectory()) {
                result += indent() + ANSI_CYAN + path + ": " + ANSI_RESET + ANSI_YELLOW + "is a file." + ANSI_RESET + "\n";
            } else {
                File[] files = directory.listFiles();
                Arrays.sort(files);

                for (File file : files) {
                    if (!file.isDirectory()) {
                        result += indent() + "F  " + file.getName() + " - " + getLastModifiedDate(file) + "\n";
                    }
                }

                for (File file : files) {
                    if (file.isDirectory()) {
                        result += indent() + ANSI_BLUE + "D  " + file.getName() + ANSI_RESET + " - " + getLastModifiedDate(file) + ANSI_RESET + "\n";
                        depth++;
                        result += getChildItemsRecursive(file.getAbsolutePath());
                        depth--;
                    }
                }
            }
        } catch(Exception e) {
            System.out.println(ANSI_CYAN + path + ". " + ANSI_RESET + ANSI_YELLOW + "Unexpected error: " + ANSI_RESET + "Commander, signal the following in all languages and in all frequencies: 'We surrender'.");
        }
        return result;
    }

    private static String indent() {
        String result = "";
        for (int i = 0; i < depth; i++) {
            result += "-";
        }
        return result;
    }

    private static String getLastModifiedDate(File file) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date lastModified = new Date(file.lastModified());
        return "Last Modified Date: " + sdf.format(lastModified);
    }
}