package com.home.StringTask;

import java.io.*;

public class StringTask10 {

    public static void main(String[] args) throws IOException{
        File file1 = new File("C:/Users/Tex88/Desktop/"+args[0]+".txt");
        File file2 = new File("C:/Users/Tex88/Desktop/"+args[1]+".txt");
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        String[] words = reader.readLine().split(" ");
        reader.close();
        String numRegex   = ".*[0-9].*";
        String lineToWrite="";
        for (String i:words) {
            if (i.matches(numRegex)) {
                lineToWrite=lineToWrite+i+" ";
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        writer.write(lineToWrite);
        writer.close();

    }

}
