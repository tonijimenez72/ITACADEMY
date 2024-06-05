package n1exercise2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class GetPath {
    private static int depth = 0;

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static String checkParameter(String[] args) {
        String result;
        if (args.length < 1) {
            result = "Please, provide a path as parameter. +\n"
                    + "Follow the README.md instructions";
        } else {
            result = args[0];
        }
        return result;
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
                if (files == null || files.length == 0) {
                    result += indent() + ANSI_BLUE + path + ANSI_RESET + " - " + ANSI_RESET + ANSI_YELLOW + "empty directory." + ANSI_RESET + "\n";
                } else {
                    Arrays.sort(files);
                    for (File file : files) {
                        if (file.isDirectory()) {
                            result += indent() + ANSI_BLUE + "D  " + file.getName() + ANSI_RESET + " - " + getLastModifiedDate(file) + ANSI_RESET + "\n";
                            depth++;
                            result += getChildItemsRecursive(file.getAbsolutePath());
                            depth--;
                        } else {
                            result += indent() + ANSI_CYAN + "F  " + file.getName()  + ANSI_RESET + " - " + getLastModifiedDate(file) + "\n";
                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.println(ANSI_CYAN + path + ". " + ANSI_RESET + ANSI_YELLOW + "Unexpected error: " + ANSI_RESET + "Commander, signal the following in all languages and in all frequencies: 'We surrender'.");
        }
        return result;
    }

    private static String indent() {
        String result = "";
        for (int i = 0; i < depth; i++) { // Utiliza depth para la indentación
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
