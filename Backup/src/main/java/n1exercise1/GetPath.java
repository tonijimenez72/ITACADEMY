package n1exercise1;

import java.io.File;
import java.util.Arrays;

public class GetPath {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static String checkParameter(String[] args) {
        String result = "";
        if (args.length < 1) {
            result = "Please, provide a path as parameter.\n"
                    + "Follow the README.md instructions";
        } else {
            result = args[0];
        }
        return result;
    }

    public static String getChildItems(String path) {
        String result = "";

        try{
            path = path.replace("/", File.separator).replace("\\", File.separator);
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
                    result = ANSI_CYAN + path + ":\n" + ANSI_RESET + ANSI_GREEN + result + ANSI_RESET;
                }
            }
        }catch(Exception e){
            System.out.println(ANSI_CYAN + path + ". " + ANSI_RESET + ANSI_YELLOW + "Unexpected error: " + ANSI_RESET + "Commander, signal the following in all languages and in all frequencies: 'We surrender'.");
        }
        return result;
    }
}
