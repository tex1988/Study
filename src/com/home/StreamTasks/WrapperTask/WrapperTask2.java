package com.home.StreamTasks.WrapperTask;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class WrapperTask2 {

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);
        System.setOut(stream);
        System.out.println("tesdd te dsdfte te sddtesfdfte");
        String result=out.toString().replaceAll("te", "??");
        System.setOut(consoleStream);
        System.out.println(result);
    }
}
