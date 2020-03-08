package com.home.StreamTasks;

import java.io.*;

public class StreamTask9 {

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        File file1 = new File("C:/Users/Tex88/Desktop/"+reader.readLine()+".txt");
        File file2 = new File("C:/Users/Tex88/Desktop/"+reader.readLine()+".txt");
        File file3 = new File("C:/Users/Tex88/Desktop/"+reader.readLine()+".txt");

        FileInputStream fileIn1 = new FileInputStream(file2);
        FileInputStream fileIn2 = new FileInputStream(file3);
        FileOutputStream fileOut = new FileOutputStream(file1);

        while (fileIn1.available()>0) {
            fileOut.write(fileIn1.read());
        }
        fileIn1.close();

        while (fileIn2.available()>0) {
            fileOut.write(fileIn2.read());
        }
        fileIn2.close();
        fileOut.close();

    }
}
