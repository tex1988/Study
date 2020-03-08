package com.home.StreamTasks;

import java.io.*;
import java.util.ArrayList;

public class StreamTask3 {

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileIn = new FileInputStream("C:/Users/Tex88/Desktop/"+reader.readLine()+".txt");
        File reverseFile = new File("C:/Users/Tex88/Desktop/"+reader.readLine()+".txt");

        ArrayList<Integer> byteList = new ArrayList<>();

        while (fileIn.available()>0) {
            byteList.add(fileIn.read());
        }

        fileIn.close();

        FileOutputStream fileOut = new FileOutputStream(reverseFile);

        for (int i=byteList.size()-1; i>=0; i--)
        {
            fileOut.write(byteList.get(i));
        }

        fileOut.close();
    }
}
