package n1exercise3;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class TreeDir {

    private static int depth = 0;

    public static String checkParameter(String[] args) {
        String path = "";
        if (args.length > 0) {
            path = args[0];
        } else {
            Scanner scanner = new Scanner(System.in);
            while (path.isEmpty()) {
                System.out.println("Path not provided as parameter\n"
                        + "Please, enter a valid path to save tree (example: C:/Test):");
                path = scanner.nextLine();
            }
        }
        return path;
    }

    public static String formatPath(String path) {
        String os = System.getProperty("os.name").toLowerCase();
        path = path.replace("\"", "");
        return path;
    }

    public static String getChildItemsRecursive(String path) {
        StringBuilder result = new StringBuilder();

        path = formatPath(path);
        try {
            File directory = new File(path);

            if (!directory.exists()) {
                result.append(indent()).append(path).append(": ").append("unknown path.").append("\n");
            } else if (!directory.isDirectory()) {
                result.append(indent()).append(path).append(": ").append("is a file.").append("\n");
            } else {
                File[] files = directory.listFiles();
                if (files != null) {
                    Arrays.sort(files);

                    for (File file : files) {
                        if (!file.isDirectory()) {
                            result.append(indent()).append("F  ").append(file.getName()).append(" - ").append(getLastModifiedDate(file)).append("\n");
                        }
                    }

                    for (File file : files) {
                        if (file.isDirectory()) {
                            result.append(indent()).append("D  ").append(file.getName()).append(" - ").append(getLastModifiedDate(file)).append("\n");
                            depth++;
                            result.append(getChildItemsRecursive(file.getAbsolutePath()));
                            depth--;
                        }
                    }
                }
            }
        } catch (Exception e) {
            result.append(path).append(". ").append("Unexpected error: ").append("Commander, signal the following in all languages and in all frequencies: 'We surrender'.");
        }
        return result.toString();
    }

    private static String indent() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            result.append("-");
        }
        return result.toString();
    }

    private static String getLastModifiedDate(File file) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date lastModified = new Date(file.lastModified());
        return "Last Modified Date: " + sdf.format(lastModified);
    }
}
