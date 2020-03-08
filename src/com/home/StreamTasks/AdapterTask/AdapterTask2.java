package com.home.StreamTasks.AdapterTask;

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterTask2 {

    public interface AmigoStringWriter {
        public void flush() throws IOException;

        void writeString(String s) throws IOException;

        void close() throws IOException;
    }

    public static class AdapterFileOutputStream implements AmigoStringWriter {

        private FileOutputStream fileIn;

        AdapterFileOutputStream (FileOutputStream fileIn) {
            this.fileIn=fileIn;
        }

        @Override
        public void flush() throws IOException {
            fileIn.flush();
        }

        @Override
        public void writeString(String s) throws IOException {
            fileIn.write(s.getBytes());
        }

        @Override
        public void close() throws IOException {
            fileIn.close();
        }
    }

    public static void main(String[] args) throws IOException{

        FileOutputStream fileIn = new FileOutputStream("C:/Users/Tex88/Desktop/File.txt");
        AmigoStringWriter writer = new AdapterFileOutputStream(fileIn);
        writer.writeString("sdsdsdsddsdsd");
    }
}
