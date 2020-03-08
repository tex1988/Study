package com.home.StreamTasks;

import java.io.*;
import java.util.ArrayList;

public class StreamTask5 {


    static public class AmigoOutputStream extends FileOutputStream {

        @Override
        public void close() throws IOException {
            String signature ="JavaRush © 2012-2013 All rights reserved.";
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("[Вы действительно хотите закрыть поток? Д/Н]");
            if (reader.readLine().equals("Д")) {
                super.write(signature.getBytes());
                super.flush();
                super.close();
            }
        }

        public AmigoOutputStream(String s) throws FileNotFoundException {
            super(s);
        }

        public AmigoOutputStream(String s, boolean b) throws FileNotFoundException {
            super(s, b);
        }

        public AmigoOutputStream(File file) throws FileNotFoundException {
            super(file);
        }

        public AmigoOutputStream(File file, boolean b) throws FileNotFoundException {
            super(file, b);
        }

        public AmigoOutputStream(FileDescriptor fileDescriptor) {
            super(fileDescriptor);
        }
    }



    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileIn = new FileInputStream("C:/Users/Tex88/Desktop/"+reader.readLine()+".txt");
        File reverseFile = new File("C:/Users/Tex88/Desktop/"+reader.readLine()+".txt");

        ArrayList<Integer> byteList = new ArrayList<>();

        while (fileIn.available()>0) {
            byteList.add(fileIn.read());
        }

        fileIn.close();

        AmigoOutputStream fileOut = new AmigoOutputStream(reverseFile);

        for (int i=byteList.size()-1; i>=0; i--)
        {
            fileOut.write(byteList.get(i));
        }

        fileOut.close();

    }
}
