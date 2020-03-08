package com.home.StreamTasks;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class StreamTask1 {

    public  static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileIn = new FileInputStream("C:/Users/Tex88/Desktop/"+reader.readLine());

        Map<Integer, Integer> byteMap = new LinkedHashMap<>();

        ArrayList<Integer> byteList = new ArrayList<>();

        while (fileIn.available()>0) {
            byteList.add(fileIn.read());
        }
        fileIn.close();

        Collections.sort(byteList);

        System.out.println(byteList.get(byteList.size()-1));
        System.out.println(byteList.get(0));

        for (int i=0; i<byteList.size(); i++){
            if (byteMap.containsKey(byteList.get(i))){
                byteMap.put(byteList.get(i), byteMap.get(byteList.get(i))+1);
            }
            else {byteMap.put(byteList.get(i), 1);}
        }

        Set<Map.Entry<Integer, Integer>> mapEntries = byteMap.entrySet();
        List<Map.Entry<Integer, Integer>> tmpList = new LinkedList<Entry<Integer,Integer>>(mapEntries);
        Collections.sort(tmpList, new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> ele1, Entry<Integer, Integer> ele2) {
                return ele1.getValue().compareTo(ele2.getValue());
            }
        });
        LinkedHashMap<Integer, Integer> sortedByteMap=new LinkedHashMap<>();
        for (Entry<Integer,Integer> i: tmpList){
            sortedByteMap.put(i.getValue(), i.getKey());
        }

        int max=0;
        int min=sortedByteMap.get(1);
        for (Map.Entry<Integer, Integer> i:sortedByteMap.entrySet()){
            max=i.getValue();
        }
        System.out.println(min);
        System.out.println(max);
        for (Map.Entry<Integer, Integer> i:byteMap.entrySet()){
            System.out.print(i.getKey()+" ");
        }




    }
}
