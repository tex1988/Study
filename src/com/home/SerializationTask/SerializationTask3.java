package com.home.SerializationTask;


import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class SerializationTask3 {

    public static Map<String, String> properties = new HashMap<>();
    public static Properties props = new Properties();

    static public void fillInPropertiesMap() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader("C:/Users/Tex88/Desktop/"+reader.readLine()+".txt"));
        reader.close();
        String propertiesLine;
        while ((propertiesLine=fileReader.readLine())!=null) {
            String[] props = propertiesLine.split(" ");
            properties.put(props[0], props[1]);
        }
        fileReader.close();
    }

    public static void save (OutputStream outputStream) {
        PrintWriter writer = new PrintWriter(outputStream);
        for (Map.Entry<String, String> i:properties.entrySet()) {
            writer.println(i.getKey()+" "+i.getValue());
        }
        writer.flush();
    }

    public static Map<String, String> load (InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Map<String, String> newMap = new LinkedHashMap<>();
        String line;
        while ((line=reader.readLine())!=null) {
            String[] props = line.split(" ");
            newMap.put(props[0], props[1]);
        }
        /*reader.close();*/
        return newMap;
    }

    public static void main(String[] args) throws IOException {
        fillInPropertiesMap();
        File propertiesFile = new File("C:/Users/Tex88/Desktop/File.properties");
        OutputStream fileOut = new FileOutputStream(propertiesFile);
        System.out.println(properties);
        save(fileOut);
        InputStream fileIn = new FileInputStream(propertiesFile);
        Map<String, String> map = new LinkedHashMap<>(load(fileIn));
        System.out.println(map);
        props.load(fileIn);
        System.out.println(props.getProperty("weight"));
    }
}
