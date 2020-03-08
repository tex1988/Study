package com.home.StreamTasks;

import java.io.*;
import java.util.ArrayList;

public class StreamTask21 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("C:/Users/Tex88/Desktop/" + reader.readLine() + ".txt");
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = fileReader.readLine())!=null) {
            String[] words = line.split(" ");
            ArrayList reverseWords = new ArrayList();
            for (String i:words) {
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                reverseWords.add(sb.reverse().toString());
                sb.delete(0, sb.length());
            }
            String printLine="";
            for (int i=reverseWords.size()-1; i>=0; i--) {
                printLine=printLine+reverseWords.get(i)+" ";
            }
            System.out.println(printLine);
        }
        fileReader.close();
    }
}
