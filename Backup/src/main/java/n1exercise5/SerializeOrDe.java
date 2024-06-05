package n1exercise5;

import java.io.*;

public class SerializeOrDe {
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
        return person.toString();
    }
}
