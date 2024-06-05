package n1exercise5;

import java.io.File;

import static n1exercise5.SerializeOrDe.deSerialize;
import static n1exercise5.SerializeOrDe.serialize;

public class Main {
    public static final String ANSI_GREEN = "\u001b[32m";
    public static final String ANSI_YELLOW = "\u001b[33m";
    public static final String ANSI_RESET = "\u001b[0m";

    public static void main(String[] args) {
        String path = GetPath.checkParameter(args);

        System.out.println(GetPath.writeToFile(GetPath.getChildItemsRecursive(path)));
        GetPath.readFileContents();

        String filePath = System.getProperty("user.dir") + "/bin/person.ser";

        File file = new File(filePath);
        Person person = new Person("Adam", "West");

        serialize(file, person);

        System.out.println(ANSI_YELLOW + "\nSerialized file path: \n" + ANSI_RESET
                + filePath + "\n\n"
                + ANSI_GREEN + "Deserialized: " + ANSI_RESET + deSerialize(file) + "\n");

    }
}