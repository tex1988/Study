package com.home.FileTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileTask6 {
    public static Properties getProperties(File file) {
        Properties properties = new Properties();
        String stringPath = file.getPath();
        try {
            if (stringPath.substring(stringPath.length()-4, stringPath.length()).equalsIgnoreCase(".xml")) {
                FileInputStream fileInputStream = new FileInputStream(file);
                properties.loadFromXML(fileInputStream);
            }
            else {
                properties.load(new FileReader(file));
            }
        } catch (IOException e) {properties = new Properties();}
        return properties;
    }

    public static void main(String[] args) {
        File file = new File(args[0]);
        Properties properties = getProperties(file);
        properties.list(System.out);
    }
}
