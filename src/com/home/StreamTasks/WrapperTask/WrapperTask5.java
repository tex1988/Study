package com.home.StreamTasks.WrapperTask;


import java.io.*;

public class WrapperTask5 {

    public static void main(String[] args) throws IOException{

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);
        System.setOut(stream);
        System.out.println("it's a text for testing");
        System.setOut(consoleStream);
        File file = new File("C:/Users/Tex88/Desktop/File.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(out.toString());
        writer.close();
    }

}
