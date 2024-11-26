package n1exercise5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationHandler {

    public static File getSerializedFile() {
        String userHome = System.getProperty("user.home");
        File serializedFolder = new File(userHome, "Documents" + File.separator + "serialized");

        boolean created = serializedFolder.exists() || serializedFolder.mkdirs();
        System.out.println(created ? "Folder 'serialized' created at: " + serializedFolder.getPath() : "Failed to create folder 'serialized'.");

        return new File(serializedFolder, "user.ser");
    }

    public static void serialize(File file, Object object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(object);
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            System.err.println("Error during serialization:");
            e.printStackTrace();
        }
    }

    public static Object deserialize(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization:");
            e.printStackTrace();
            return null;
        }
    }
}