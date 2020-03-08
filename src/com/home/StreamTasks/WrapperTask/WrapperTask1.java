package com.home.StreamTasks.WrapperTask;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class WrapperTask1 {

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);
        System.setOut(stream);
        System.out.println("sdsdsd");
        String result = out.toString().toUpperCase();
        System.setOut(consoleStream);
        System.out.println(result);


    }

}
