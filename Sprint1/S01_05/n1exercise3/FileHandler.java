package n1exercise3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    public void run(String[] args) {
        String path = resolvePath(args);
        String directoryContent = getChildItem(path);
        saveToFile(directoryContent);
    }

    private String resolvePath(String[] args) {
        if (args != null && args.length > 0) {
            return args[0];
        }

        Scanner scanner = new Scanner(System.in);
        String path = "";
        while (path.isEmpty()) {
            System.out.println("Path not provided as parameter.\n"
                    + "Please, enter a valid path (example: C:/Test):");
            path = scanner.nextLine();
        }
        return path;
    }

    public String getChildItem(String path) {
        File directory = new File(path);

        if (!directory.exists()) {
            return path + ": unknown path.\n";
        }

        if (!directory.isDirectory()) {
            return path + ": is a file.\n";
        }

        return listDirectoryTreeRecursive(directory, 0);
    }

    private String listDirectoryTreeRecursive(File directory, int level) {
        File[] files = directory.listFiles();

        if (isDirectoryEmpty(files)) {
            return formatDirectoryAsEmpty(directory, level);
        }

        List<File> sortedFiles = sortFilesAndDirectories(files);
        return processFilesAndDirectories(sortedFiles, level);
    }

    private boolean isDirectoryEmpty(File[] files) {
        return files == null || files.length == 0;
    }

    private List<File> sortFilesAndDirectories(File[] files) {
        List<File> fileList = filterFiles(files, true);
        List<File> directoryList = filterFiles(files, false);

        sortFileList(fileList);
        sortFileList(directoryList);

        return combineFileLists(fileList, directoryList);
    }

    private List<File> filterFiles(File[] files, boolean isFile) {
        List<File> filteredList = new ArrayList<>();
        for (File file : files) {
            if (file.isFile() == isFile) {
                filteredList.add(file);
            }
        }
        return filteredList;
    }

    private void sortFileList(List<File> fileList) {
        fileList.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
    }

    private List<File> combineFileLists(List<File> fileList, List<File> directoryList) {
        List<File> combinedList = new ArrayList<>(fileList);
        combinedList.addAll(directoryList);
        return combinedList;
    }

    private String processFilesAndDirectories(List<File> files, int level) {
        StringBuilder result = new StringBuilder();

        for (File file : files) {
            String indent = " ".repeat(level * 2);

            if (file.isDirectory() && isDirectoryEmpty(file.listFiles())) {
                result.append(formatDirectoryAsEmpty(file, level));
            } else {
                result.append(formatFileDetails(file, indent));

                if (file.isDirectory()) {
                    result.append(listDirectoryTreeRecursive(file, level + 1));
                }
            }
        }

        return result.toString();
    }

    private String formatDirectoryAsEmpty(File directory, int level) {
        String indent = " ".repeat(level * 2);
        return indent + "[Directory] " + directory.getName() + ": empty directory.\n";
    }

    private String formatFileDetails(File file, String indent) {
        String type = file.isDirectory() ? "[Directory]" : "[File]";
        String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified());

        return indent + type + " " + file.getName() + " (Last modified: " + lastModified + ")\n";
    }

    public void saveToFile(String content) {
        File logDirectory = createLogDirectory();
        File logFile = new File(logDirectory, "ls.txt");

        writeToFile(logFile, content);
    }

    private File createLogDirectory() {
        boolean dirCreated;
        File logDirectory = new File(System.getProperty("user.home") + "/Documents/Logs");

        if (!logDirectory.exists()) {
            dirCreated = logDirectory.mkdirs();

            System.out.println(dirCreated ? "Logs folder created." : "Failed to create Logs folder.");
        }

        return logDirectory;
    }

    private void writeToFile(File logFile, String content) {
        try (FileWriter writer = new FileWriter(logFile)) {
            writer.write(content);
            System.out.println("Directory listing saved to " + logFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.run(args);
    }
}
