package com.home.StreamTasks;


import java.io.*;
import java.util.*;

public class StreamTask17 {

    public static void main(String[] args) throws IOException{

        File file = new File("C:/Users/Tex88/Desktop/"+args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        TreeMap<String, Double> map = new TreeMap<>();
        String line="";
        String[] splitedLine;
        while ((line=reader.readLine())!=null) {
            splitedLine=line.split(" ");
            if (map.containsKey(splitedLine[0])) {
                map.put(splitedLine[0], map.get(splitedLine[0])+Double.parseDouble(splitedLine[1]));
            }
            else {
                map.put(splitedLine[0], Double.parseDouble(splitedLine[1]));
            }
        }
        reader.close();

        System.out.println(map);
        Map<String, Double> sortedMap = new LinkedHashMap<>();
        Set<Map.Entry<String, Double>> entrySet = map.entrySet();
        List<Map.Entry<String, Double>> sortedList = new LinkedList<>(entrySet);
        Collections.sort(sortedList, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> stringDoubleEntry, Map.Entry<String, Double> t1) {
                return t1.getValue().compareTo(stringDoubleEntry.getValue());
            }
        });
        for (Map.Entry<String, Double> i:sortedList) {
            sortedMap.put(i.getKey(), i.getValue());
        }

        System.out.println(sortedList.get(0).getKey());

    }

}
