package com.home.StreamTasks;

import java.io.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class StreamTask14 {

    public static Map<String, Integer> resultMap = new LinkedHashMap<>();

    static public class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            Map<Integer, Integer> byteMap = new LinkedHashMap<>();
            int tmpByte;
            try {
                File file = new File("C:/Users/Tex88/Desktop/" + fileName + ".txt");
                FileInputStream fileIn = new FileInputStream(file);
                while (fileIn.available()>0) {
                    tmpByte=fileIn.read();
                    if (byteMap.containsKey(tmpByte)) {
                        byteMap.put(tmpByte, byteMap.get(tmpByte)+1);
                    }
                    else {byteMap.put(tmpByte,1);}
                }
                fileIn.close();
            }
            catch (FileNotFoundException e){System.out.println(e);}
            catch (IOException e) {System.out.println(e);}
            Map.Entry<Integer, Integer> max = null;
            for (Map.Entry<Integer, Integer> i:byteMap.entrySet()) {
                if (max == null || max.getValue() < i.getValue()) {
                    max = i;
                }
            }
            synchronized (this){
                resultMap.put(this.fileName, max.getKey());
            }

        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName=reader.readLine()).equals("exit")) {
            new ReadThread(fileName).start();
        }
        reader.close();
        System.out.println(resultMap);
    }
}
