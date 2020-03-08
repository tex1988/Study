package com.home.StringTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class StringTask {

    public static void recursion (char[] ch, int length)
    {
        try {
            System.out.print(ch[ch.length-length]);
            if (length==0) return;
            recursion(ch, length+1);
        }
        catch (ArrayIndexOutOfBoundsException e){}
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[]list=new String[5];
        for (int i=0; i<5; i++)
        {
            list[i]=reader.readLine();
        }

        for (int j=list.length-1; j>0; j--)
        {
            for (int i=0; i<j; i++)
            {
                if (list[i].length()>list[i+1].length())
                {
                    String tmp = list[i];
                    list[i]=list[i+1];
                    list[i+1]=tmp;
                }
            }
        }

        for(String i:list)
        {
            System.out.println(i);
        }

   }
}