package com.utility;

import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReaderManager {
    private static Properties properties;

    public static void setupProperty() {
        File file = new File("C:\\Users\\user\\IdeaProjects\\Frame_Work\\src\\main\\resources\\TestData.properties");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            Assert.fail("ERROR: OCCUR DURING FILE LOADING - " + e.getMessage());
        } catch (IOException e) {
            Assert.fail("ERROR : OCCUR DURING FILE READING - " + e.getMessage());
        }
    }

    public static String getDataProperty(String value) {
        setupProperty();
        return properties.getProperty(value);
    }

    static void main() {
        System.out.println(getDataProperty("browser"));
    }
}
