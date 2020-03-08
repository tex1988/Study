package com.home.StreamTasks.WrapperTask;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class WrapperTask4 {

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);
        System.setOut(stream);
        System.out.println("300+28=");
        String result = out.toString();
        System.setOut(consoleStream);
        if (result.contains("+")) {
            int a = Integer.parseInt(result.substring(0, result.indexOf("+")));
            int b = Integer.parseInt(result.substring(result.indexOf("+")+1, result.indexOf("=")));
            System.out.println(a+b);
        }
        else {
            int a = Integer.parseInt(result.substring(0, result.indexOf("-")));
            int b = Integer.parseInt(result.substring(result.indexOf("-")+1, result.indexOf("=")));
            System.out.println(a-b);
        }

    }
}
