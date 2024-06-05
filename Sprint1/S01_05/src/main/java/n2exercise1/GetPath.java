package n2exercise1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

public class GetPath {
    private static int depth = 0;

    public static Properties loadConfig() throws IOException {
        Properties prop = new Properties();

        try (InputStream input = GetPath.class.getClassLoader().getResourceAsStream("resources/config.properties")) {
            System.out.println(input);
            if (input == null) {
                throw new IOException("Unable to find config.properties");
            }
            prop.load(input);
        }
        return prop;
    }

    public static String checkParameter(Properties prop) {
        String result;
        String directoryToRead = prop.getProperty("readPath");
        if (directoryToRead == null || directoryToRead.isEmpty()) {
            result = "Please, provide a path in the config.properties file.\n"
                    + "Follow the README.md instructions";
        } else {
            result = directoryToRead;
        }
        return result;
    }

    public static String getChildItemsRecursive(String path) {
        StringBuilder result = new StringBuilder();

        path = path.replace("/", File.separator).replace("\\", File.separator);
        try {
            File directory = new File(path);

            if (!directory.exists()) {
                result.append(indent()).append(path).append(": unknown path.\n");
            } else if (!directory.isDirectory()) {
                result.append(indent()).append(path).append(": is a file.\n");
            } else {
                File[] files = directory.listFiles();
                if (files == null || files.length == 0) {
                    result.append(indent()).append(path).append(" - empty directory.\n");
                } else {
                    Arrays.sort(files);
                    for (File file : files) {
                        if (file.isDirectory()) {
                            result.append(indent()).append("D  ").append(file.getName()).append(" - ").append(getLastModifiedDate(file)).append("\n");
                            depth++;
                            result.append(getChildItemsRecursive(file.getAbsolutePath()));
                            depth--;
                        } else {
                            result.append(indent()).append("F  ").append(file.getName()).append(" - ").append(getLastModifiedDate(file)).append("\n");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(path + ". Unexpected error: Commander, signal the following in all languages and in all frequencies: 'We surrender'.");
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

    public static String writeToFile(String content) {
        String result = "";
        String fileName = System.getProperty("user.dir") + "/resources/s2exercise1.txt";
        fileName = fileName.replace("/", File.separator).replace("\\", File.separator);
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            result = "File saved in " + fileName;
        } catch (IOException e) {
            System.out.println("Error saving the " + fileName + ": " + e.getMessage());
        }
        return result;
    }
}
