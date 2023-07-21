package com.Support;

import java.io.FileReader;
import java.util.Properties;

public class Utils {

    Properties properties;
    static String path = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";

    public Properties getProperty() {
        properties = new Properties();
        try {
            FileReader reader = new FileReader(path);
            properties.load(reader);
        } catch (Exception exception) {
            System.out.println(exception.getCause());
            System.out.println(exception.getMessage());
        }
        return properties;
    }
}
