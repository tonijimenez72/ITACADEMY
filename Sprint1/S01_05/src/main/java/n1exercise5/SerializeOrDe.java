package n1exercise5;

import java.io.*;

public class SerializeOrDe {
    public static final String ANSI_GREEN = "\u001b[32m";
    public static final String ANSI_YELLOW = "\u001b[33m";
    public static final String ANSI_RESET = "\u001b[0m";

    public static void serializeTest() {
        String serFile = "person.ser";
        String filePath = IOLog.getResourceFilePath(serFile);

        System.out.println(filePath);

        File file = new File(filePath);
        Person person = new Person("Adam", "Weeest");
        serialize(file, person);

        System.out.println(ANSI_YELLOW + "\nSerialized file path: \n" + ANSI_RESET
                + filePath + "\n\n"
                + ANSI_GREEN + "Deserialized: " + ANSI_RESET + deSerialize(file) + "\n");
    }

    public static void serialize(File file, Person person) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String deSerialize(File file) {
        Person person = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            person = (Person) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return person != null ? person.toString() : "";
    }
}

