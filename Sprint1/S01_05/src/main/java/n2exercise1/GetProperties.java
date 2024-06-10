package n2exercise1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {
    public static String getProperties(String property) {
        String configFile = "configuration.properties";
        String configFilePath = IOLog.getResourceFilePath(configFile);
        Properties prop = new Properties();
        String result = "";

        try (FileInputStream input = new FileInputStream(configFilePath)) {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        result = prop.getProperty(property);
        return result;
    }
}
