package com.fishguard;

import java.io.*;
import java.util.Properties;

/**
 * ConfigLoader manages system environment variables.
 * Session 19: Decoupling settings from source code.
 */
public class ConfigLoader {
    private Properties properties = new Properties();

    public ConfigLoader() {
        try (InputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
            System.out.println("[CONFIG]: Settings loaded successfully.");
        } catch (IOException ex) {
            System.out.println("[ERROR]: Could not find config.properties. Using defaults.");
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
