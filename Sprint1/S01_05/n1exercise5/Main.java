package n1exercise5;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        User user = new User("user1", "user1@n1exercise5.com");

        File file = SerializationHandler.getSerializedFile();

        SerializationHandler.serialize(file, user);

        System.out.println("Deserialized User: " + SerializationHandler.deserialize(file));
    }
}