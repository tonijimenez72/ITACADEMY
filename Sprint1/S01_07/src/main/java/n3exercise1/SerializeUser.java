package n3exercise1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class SerializeUser {
    public static void serializeObject(User user) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Class<?> userClass = user.getClass();
        Field[] fields = userClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(JSONSerialize.class)) {
                JSONSerialize annotation = field.getAnnotation(JSONSerialize.class);
                String directory = annotation.directory();
                String outputDirectory = System.getProperty("user.dir") + "/" + directory;

                // Verificar si el directorio de salida existe y crearlo si no
                File outputDir = new File(outputDirectory);
                if (!outputDir.exists()) {
                    if (!outputDir.mkdirs()) {
                        System.err.println("Failed to create output directory");
                        return;
                    }
                }

                // Print annotation information
                System.out.println("Field: " + field.getName());
                System.out.println("Annotation directory: " + annotation.directory());

                String filename = outputDirectory + "/" + field.getName() + ".json";

                try (FileWriter writer = new FileWriter(filename)) {
                    field.setAccessible(true); // Make the private field accessible
                    gson.toJson(field.get(user), writer);
                    System.out.println("File created: " + filename);
                } catch (IOException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
