package n1exercise4;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileHandler {

    public void run(String[] args) {
        if (args.length == 0 || (!args[0].equalsIgnoreCase("-ls") && !args[0].equalsIgnoreCase("-rf"))) {
            args = promptForFirstArgument();
        }

        if (args[0].equalsIgnoreCase("-ls")) {
            String path = args[1];
            listDirectoryContent(path);
        } else if (args[0].equalsIgnoreCase("-rf")) {
            String path = args[1];
            readFile(path);
        }
    }

    private String[] promptForFirstArgument() {
        Scanner scanner = new Scanner(System.in);
        String[] args = new String[2];

        System.out.println("Please provide the option:");
        System.out.println("-ls save directory contents to ls.txt file.");
        System.out.println("-rf read a file.");
        args[0] = scanner.nextLine();

        System.out.println("Please, enter the path:");
        args[1] = scanner.nextLine();

        return args;
    }

    public void listDirectoryContent(String path) {
        String directoryContent = getChildItem(path);
        saveToFile(directoryContent);
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

    public void readFile(String path) {
        File file = new File(path);

        if (!file.exists()) {
            System.out.println(path + ": file not found.");
            return;
        }

        if (!file.isFile()) {
            System.out.println(path + ": is a directory, not a file.");
            return;
        }

        String content = readFileContent(file);
        System.out.println("File content:\n" + content);
    }

    private String readFileContent(File file) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return content.toString();
    }
}