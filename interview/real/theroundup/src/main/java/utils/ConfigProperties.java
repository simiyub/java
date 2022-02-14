package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
    private Properties properties;

    public ConfigProperties(String propertiesFile) {

        properties = new Properties();
        try (InputStream stream = ClassLoader.getSystemResourceAsStream(propertiesFile)){
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public final String getProperty(String key) {
        return properties.getProperty(key);
    }
}
