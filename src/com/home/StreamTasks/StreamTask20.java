package com.home.StreamTasks;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class StreamTask20 {

    public static void main(String[] args) throws IOException{

        File file1 = new File("C:/Users/Tex88/Desktop/" + args[0] + ".txt");
        File file2 = new File("C:/Users/Tex88/Desktop/" + args[1] + ".txt");
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        String readLine = reader.readLine();
        reader.close();
        String[] readWords = readLine.split(" ");
        ArrayList<String> writeWords = new ArrayList<>();
        for (String i:readWords) {
            if (i.length()>7) {
                writeWords.add(i);
            }
        }
        String writeLine="";
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        Iterator iter = writeWords.iterator();
        while (iter.hasNext()){
            writeLine=writeLine+iter.next()+",";
            if (!iter.hasNext()) {
                writeLine=writeLine.substring(0, writeLine.length()-1);
            }
        }
        writer.write(writeLine);
        writer.close();
    }

}
