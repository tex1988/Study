package com.home.StreamTasks;

import java.io.*;
import java.util.ArrayList;

public class StreamTask6 {


    public static class TxtInputStream extends FileInputStream {

        private class UnsupportedFileNameException extends Exception {

        }

        public TxtInputStream(String s) throws FileNotFoundException, UnsupportedFileNameException{
            super(s);
            if (!s.contains(".txt")){
                throw new UnsupportedFileNameException();
            }
        }

        public TxtInputStream(File file) throws FileNotFoundException {
            super(file);
        }

        public TxtInputStream(FileDescriptor fileDescriptor) {
            super(fileDescriptor);
        }
    }

    public static void main(String[] args) throws IOException, TxtInputStream.UnsupportedFileNameException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TxtInputStream fileIn = new TxtInputStream("C:/Users/Tex88/Desktop/"+reader.readLine());

        File reverseFile = new File("C:/Users/Tex88/Desktop/"+reader.readLine()+".txt");

        ArrayList<Integer> byteList = new ArrayList<>();

        while (fileIn.available()>0) {
            byteList.add(fileIn.read());
        }

        fileIn.close();

        StreamTask5.AmigoOutputStream fileOut = new StreamTask5.AmigoOutputStream(reverseFile);

        for (int i=byteList.size()-1; i>=0; i--)
        {
            fileOut.write(byteList.get(i));
        }

        fileOut.close();

    }
}
