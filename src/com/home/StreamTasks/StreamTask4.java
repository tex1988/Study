package com.home.StreamTasks;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class StreamTask4 {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        URL url = new URL("http://example.com/");
        while (true) {
            FileInputStream fileIn = new FileInputStream("C:/Users/Tex88/Desktop/"+reader.readLine());
            if (fileIn.available()<1000) {


                }
             fileIn.close();
        }
    }
}
