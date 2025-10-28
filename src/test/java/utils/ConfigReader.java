package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("⚠️ Failed to load config.properties");
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
