package com.home.StreamTasks;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class StreamTask16 {

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> byteBuffer = new LinkedList<>();
        String fileName="";
        String resultFileName="";
        while (!(fileName=reader.readLine()).equals("exit")) {
            File file = new File("C:/Users/Tex88/Desktop/" + fileName);
            FileInputStream fileIn = new FileInputStream(file);
            while (fileIn.available()>0) {
                byteBuffer.add(fileIn.read());
            }
            resultFileName=fileName;
            fileIn.close();
        }
        reader.close();

        File resultFile= new File ("C:/Users/Tex88/Desktop/" + resultFileName.substring(0, resultFileName.lastIndexOf(".")));

        FileOutputStream fileOut = new FileOutputStream(resultFile);
        for (Integer i:byteBuffer) {
            fileOut.write(i);
        }
    }
}
