package com.home.StreamTasks;

import java.io.*;

public class StreamTask15 {

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName="";

            while (true) {
                try {
                    fileName = "C:/Users/Tex88/Desktop/" + reader.readLine() + ".txt";
                    if(!new File(fileName).exists()) {
                        throw new FileNotFoundException();
                    }
                }
                catch (FileNotFoundException e) {
                    System.out.println(fileName + " не существует");
                    reader.close();
                    break;
                }
            }
    }
}
