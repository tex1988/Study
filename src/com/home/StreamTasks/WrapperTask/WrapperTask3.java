package com.home.StreamTasks.WrapperTask;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class WrapperTask3 {

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);
        System.setOut(stream);
        System.out.println("sdsd111sdsd223sdddsd1455sd5s4s6d4");
        String result = out.toString();
        String[] nums = {"0","1","2","3","4","5","6","7","8","9"};
        String result2="";
        for (int i=0; i<result.length();i++) {
            for (String k:nums) {
                if (result.substring(i,i+1).equals(k)) {
                    result2=result2+result.substring(i,i+1);
                }
            }
        }
        System.setOut(consoleStream);
        System.out.println(result2);
    }
}
