package com.home.StreamTasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StreamTask19 {

    public static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {

        File file = new File("C:/Users/Tex88/Desktop/" + args[0] + ".txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String lineRaw;
        while ((lineRaw = reader.readLine()) != null) {
            String line = lineRaw.replace("."," ");
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                try {
                    if (map.containsKey(Integer.parseInt(words[i]))) {
                        words[i] = map.get(Integer.parseInt(words[i]));
                    }
                }
                catch (NumberFormatException e) {}
            }
            String newLine = "";
            for (String i : words) {
                newLine = newLine + i + " ";
            }
            if (lineRaw.contains(".")){
                System.out.println(newLine.substring(0, newLine.length()-1)+".");
            }
            else {
                System.out.println(newLine);
            }

        }
        reader.close();
    }
}
