package com.home.StreamTasks;

import java.io.*;
import java.util.ArrayList;

public class StreamTask10 {

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        File file1 = new File("C:/Users/Tex88/Desktop/"+reader.readLine()+".txt");
        File file2 = new File("C:/Users/Tex88/Desktop/"+reader.readLine()+".txt");

        FileInputStream fileIn1 = new FileInputStream(file1);
        FileInputStream fileIn2 = new FileInputStream(file2);

        ArrayList<Integer> byteList = new ArrayList<>();

        while (fileIn2.available()>0) {
            byteList.add(fileIn2.read());
        }
        fileIn2.close();

        while (fileIn1.available()>0) {
            byteList.add(fileIn1.read());
        }
        fileIn1.close();

        FileOutputStream fileOut = new FileOutputStream(file1);
        for (int i=0; i<byteList.size(); i++) {
            fileOut.write(byteList.get(i));
        }
        fileOut.close();
    }
}
