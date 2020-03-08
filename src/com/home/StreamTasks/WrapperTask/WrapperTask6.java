package com.home.StreamTasks.WrapperTask;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class WrapperTask6 {

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);
        System.setOut(stream);
        TestString testString = new TestString();
        testString.printSomething();
        System.setOut(consoleStream);
        String[] lines = out.toString().split("\\n");
        for (int i=0; i<lines.length; i++) {
            System.out.println(lines[i]);
            if (i%2!=0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }

    }
}
