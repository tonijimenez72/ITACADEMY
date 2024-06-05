package n1exercise4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = GetPath.checkParameter(args);

        System.out.println(GetPath.writeToFile(GetPath.getChildItemsRecursive(path)));
        GetPath.readFileContents();
    }
}
