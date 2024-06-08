package n1exercise5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IOLog {

    public static void getLog(String[] args) {
        String readPath = GetPath.checkParameter(args);
        String recursiveLs = GetPath.getChildItemsRecursive(readPath);
        String exercise = IOLog.class.getPackage().getName();
        String writeFilePath = getResourceFilePath(exercise);
        String writeResult = writeToFile(recursiveLs, writeFilePath);

        System.out.println(writeResult);

        readFileContents(writeFilePath);
    }

    public static String getPackageName() {
        return IOLog.class.getPackage().getName();
    }

    public static boolean runningFromTerminal() {
        String classPath = System.getProperty("java.class.path");
        boolean terminal = false;

        if (classPath.equals(".")) {
            System.out.println("Running from Terminal.");
            terminal = true;
        } else {
            System.out.println("Running from IDE.");
        }
        return terminal;
    }


    public static String getResourceFilePath(String file) {
        try {
            String filePath = "";
            if (!runningFromTerminal()){
                String exercise = Main.class.getPackage().getName();
                String classFilePath = Main.class.getResource("Main.class").getPath();
                String projectPath = classFilePath.substring(1, classFilePath.indexOf("/target/classes"));
                String mainJavaPath = projectPath + "/src/main/java/" + exercise.replace(".", "/");
                filePath = mainJavaPath + "/resources/" + file;
            }else{
                filePath = "resources/" + file;
            }
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String writeToFile(String content, String writeFilePath) {
        String result = "";
        try {
            File file = new File(writeFilePath);
            File directory = file.getParentFile();
            if (!directory.exists() && !directory.mkdirs()) {
                System.err.println("Error creating directory for file: " + directory.getAbsolutePath());
                return result;
            }
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(content);
                result = "File saved in " + writeFilePath;
            }
        } catch (IOException e) {
            System.err.println("Error saving the file: " + e.getMessage());
        }
        return result;
    }

    public static void readFileContents(String writeFilePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(writeFilePath));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file " + writeFilePath + ": " + e.getMessage());
        }
    }
}