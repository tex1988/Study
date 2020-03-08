package com.home.FileTask;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class FileTask
{



    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = fileNameReader.readLine();

        BufferedReader in = new BufferedReader(new FileReader("C:/Users/Tex88/Desktop/" + fileName+".txt"));

        String s;
        ArrayList<Integer> numberList = new ArrayList<>();

        while ((s=in.readLine()) != null) {
            if (Integer.parseInt(s)%2==0)
            numberList.add(Integer.parseInt(s));
        }
        in.close();

        Collections.sort(numberList);

        File newFile = new File("C:/Users/Tex88/Desktop/" + fileName+"1.txt");
        String newline = System.getProperty("line.separator");
        BufferedWriter out = new BufferedWriter(new FileWriter("C:/Users/Tex88/Desktop/" + fileName+"1.txt"));

        for (Integer i:numberList)
        {
            System.out.println(i);
            out.write(i+newline);
        }
        out.close();
    }
}
