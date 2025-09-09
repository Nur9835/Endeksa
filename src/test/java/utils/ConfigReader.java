package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    static {
        String path = "src/test/resources/config.properties";
        try {
            FileInputStream fis = new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String Key){

        return properties.getProperty(Key);
    }



}