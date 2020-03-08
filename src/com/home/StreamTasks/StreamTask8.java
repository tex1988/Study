package com.home.StreamTasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class StreamTask8 {

    public static void main(String[] args) throws IOException{

        FileInputStream fileIn = new FileInputStream(new File(args[0]));
        int charByte;
        int charCount=0;

        int allCharCount=0;
        int spaceCharCount=0;

        while (fileIn.available()>0) {
            charByte=fileIn.read();
            if ((charByte>64 && charByte<91) || (charByte>96 && charByte<123)){charCount++;}
        }
        fileIn.close();


        FileInputStream fileIn2 = new FileInputStream(new File(args[0]));
        while (fileIn2.available()>0) {
            allCharCount++;
            charByte=fileIn2.read();
            if (charByte==32){spaceCharCount++;}
        }

        fileIn2.close();

        System.out.println(allCharCount);
        System.out.println(spaceCharCount);
        System.out.println(allCharCount/spaceCharCount);

        System.out.println(charCount);
    }


}
