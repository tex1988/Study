package com.home.StreamTasks;

import java.io.*;
import java.util.*;

public class StreamTask12 {

    public static void main(String[] args) throws IOException {

        FileInputStream fileIn = new FileInputStream(args[0]);
        LinkedHashMap<Integer, Integer> byteMap = new LinkedHashMap<>();
        int tmpByte;
        while (fileIn.available()>0) {
            tmpByte=fileIn.read();
            if (byteMap.containsKey(tmpByte)) {
                byteMap.put(tmpByte, (byteMap.get(tmpByte))+1);
            }
            else {
                byteMap.put(tmpByte, 1);
            }
        }
        fileIn.close();

        Set<Map.Entry<Integer, Integer>> byteMapEntries = byteMap.entrySet();
        List<Map.Entry<Integer, Integer>> sortList = new LinkedList<>(byteMapEntries);
        Collections.sort(sortList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> ele1, Map.Entry<Integer, Integer> ele2) {
                return ele1.getKey().compareTo(ele2.getKey());
            }
        });

        LinkedHashMap<Integer, Integer> sortedByteMap = new LinkedHashMap<>();
        for (Map.Entry<Integer,Integer> i: sortList){
            sortedByteMap.put(i.getKey(), i.getValue());
        }

        File file1 = new File("C:/Users/Tex88/Desktop/File1.txt");
        BufferedWriter fileBufOut = new BufferedWriter(new FileWriter(file1));
        String newline = System.getProperty("line.separator");
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (Map.Entry<Integer, Integer> i:sortedByteMap.entrySet()) {
            int tmpInt=i.getKey();
            map.put((char) tmpInt, i.getValue());
         }

        for (Map.Entry<Character, Integer> i:map.entrySet()) {
            String tmpString = i.getKey()+" "+i.getValue()+newline;
            System.out.print(tmpString);
            fileBufOut.write(tmpString);
        }
        fileBufOut.close();
    }
}
