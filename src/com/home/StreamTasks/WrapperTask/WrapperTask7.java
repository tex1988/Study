package com.home.StreamTasks.WrapperTask;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WrapperTask7 {

    public static class FileConsoleWriter extends FileWriter{

        public FileConsoleWriter(String s) throws IOException {
            super(s);
        }

        public FileConsoleWriter(File file) throws IOException {
            super(file);
        }

        @Override
        public void write(String s) throws IOException {
            super.write(s);
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws  IOException{

        File file = new File("C:/Users/Tex88/Desktop/File1.txt");
        String test="sdsdsddsd";
        FileConsoleWriter writer = new FileConsoleWriter(file);
        writer.write(test);
        writer.close();
    }

}
