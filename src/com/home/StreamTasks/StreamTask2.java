package com.home.StreamTasks;

import java.io.*;
import java.util.ArrayList;

public class StreamTask2 {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileIn = new FileInputStream("C:/Users/Tex88/Desktop/"+reader.readLine()+".txt");

        File file2 = new File("C:/Users/Tex88/Desktop/"+reader.readLine()+".txt");
        File file3 = new File("C:/Users/Tex88/Desktop/"+reader.readLine()+".txt");
        ArrayList<Integer> byteList = new ArrayList<>();

        while (fileIn.available()>0)
        {
            byteList.add(fileIn.read());
        }
        fileIn.close();

        FileOutputStream fileOut2 = new FileOutputStream(file2);
        FileOutputStream fileOut3 = new FileOutputStream(file3);

        for (int i = 0; i<byteList.size(); i++) {
            if (i<(byteList.size()/2+byteList.size()%2)) {
                fileOut2.write(byteList.get(i));
            }
            else {
                fileOut3.write(byteList.get(i));
            }
        }

        fileOut2.close();
        fileOut3.close();

    }

}
