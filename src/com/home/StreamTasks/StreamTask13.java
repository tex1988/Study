package com.home.StreamTasks;

import java.io.*;

public class StreamTask13 {

    public static void main(String[] args) throws IOException{

        File file = new File("C:/Users/Tex88/Desktop/File1.txt");
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        String fileLine;
        while ((fileLine=fileReader.readLine())!=null) {
            if (fileLine.startsWith(args[0])) {
                System.out.println(fileLine);
                break;
            }
        }
        fileReader.close();



    }

}
