package com.home.StringTask;

import java.io.*;

public class StringTask16 {
    public static void main(String[] args) throws IOException{
        File file1 = new File("C:/Users/Tex88/Desktop/"+args[0]+".txt");
        File file2 = new File("C:/Users/Tex88/Desktop/"+args[1]+".txt");

        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        FileOutputStream fileOut = new FileOutputStream(file2);
        String nextLine = System.getProperty("line.separator");
        String tmp;
        String text="";
        while ((tmp=fileReader.readLine())!=null) {
            text=text+tmp+nextLine;
        }
        fileReader.close();
        System.out.println(text);
        byte[] buffer = text.getBytes("Windows-1251");
        fileOut.write(buffer);
        fileOut.close();
    }
}
