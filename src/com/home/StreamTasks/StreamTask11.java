package com.home.StreamTasks;

import java.io.*;
import java.util.AbstractList;
import java.util.ArrayList;

public class StreamTask11 {

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File ("C:/Users/Tex88/Desktop/"+reader.readLine()+".txt");
        File file2 = new File ("C:/Users/Tex88/Desktop/"+reader.readLine()+".txt");
        reader.close();

        BufferedReader fileIn = new BufferedReader(new FileReader(file1));
        String numbersIn = fileIn.readLine();
        String numbersOut = "";
        String tmpNum ="";
        fileIn.close();

        for (int i = 0; i < numbersIn.length() - 1; i++) {
            if (numbersIn.substring(i, i + 1).equals(" ")) {
                numbersOut=numbersOut+Math.round(Float.parseFloat(tmpNum))+" ";
                tmpNum = "";
            }
            else {
                tmpNum = tmpNum + numbersIn.substring(i, i + 1);
            }
            if (i == numbersIn.length() - 2) {
                numbersOut=numbersOut+Math.round(Float.parseFloat(tmpNum))+" ";
            }
        }

        BufferedWriter fileOut = new BufferedWriter(new FileWriter(file2));
        fileOut.write(numbersOut);
        fileOut.close();
    }
}
