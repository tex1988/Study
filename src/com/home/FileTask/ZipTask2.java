package com.home.FileTask;

import java.io.*;
import java.nio.file.Files;

public class ZipTask2 {
    public static void main(String[] args) throws IOException {
        File filePart1 = new File(args[0]);
        File filePart2 = new File(args[1]);
        byte[] bufferPart1 = Files.readAllBytes(filePart1.toPath());
        byte[] bufferPart2 = Files.readAllBytes(filePart2.toPath());
        byte[] buffer = new byte[bufferPart1.length+bufferPart2.length];
        System.arraycopy(bufferPart1, 0, buffer, 0, bufferPart1.length);
        System.arraycopy(bufferPart2, 0, buffer,bufferPart1.length, bufferPart2.length);
        File zip = new File("C:/Users/Tex88/Desktop/44.zip");
        zip.createNewFile();
        FileOutputStream fileOut = new FileOutputStream(zip);
        fileOut.write(buffer);
        fileOut.close();
    }
}
