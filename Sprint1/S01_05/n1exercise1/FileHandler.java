package n1exercise1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    public void run(String[] args) {
        String path = checkParameter(args);
        String result = getChildItem(path);
        System.out.println(result);
    }

    private String checkParameter(String[] args) {
        String path = "";
        if (args.length > 0) {
            path = args[0];
        } else {
            Scanner scanner = new Scanner(System.in);
            while (path.isEmpty()) {
                System.out.println("Path not provided as parameter.\n"
                        + "Please, enter a valid path:");
                path = scanner.nextLine();
            }
            scanner.close();
        }
        return path;
    }

    public String getChildItem(String path) {
        File directory = new File(path);

        if (!directory.exists()) {
            return path + ": path not found.\n";
        }

        if (!directory.isDirectory()) {
            return path + ": is a file.\n";
        }

        return listDirectoryTree(directory);
    }

    private String listDirectoryTree(File directory) {
        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            return directory.getPath() + ": empty directory.\n";
        }

        List<File> sortedFiles = sortFilesAndDirectories(files);
        StringBuilder result = new StringBuilder();

        for (File file : sortedFiles) {
            result.append(formatFileDetails(file));
        }

        return result.toString();
    }

    private List<File> sortFilesAndDirectories(File[] files) {
        List<File> fileList = new ArrayList<>();
        List<File> directoryList = new ArrayList<>();

        for (File file : files) {
            if (file.isFile()) {
                fileList.add(file);
            } else if (file.isDirectory()) {
                directoryList.add(file);
            }
        }

        fileList.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        directoryList.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));

        List<File> sortedFiles = new ArrayList<>(fileList);
        sortedFiles.addAll(directoryList);

        return sortedFiles;
    }

    private String formatFileDetails(File file) {
        String type = file.isDirectory() ? "[Directory]" : "[File]";

        return type + " " + file.getName() + "\n";
    }
}