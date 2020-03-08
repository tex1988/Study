package com.home.StringTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StringTask9 {

    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("C:/Users/Tex88/Desktop/"+reader.readLine());
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        String line;

        while ((line=fileReader.readLine())!=null) {
            int counter=0;
            for (String i:words) {
                if (line.contains(i)) {
                    counter++;
                }
            }
            if (counter==2) {
                System.out.println(line);
            }
        }
        reader.close();

    }

}
