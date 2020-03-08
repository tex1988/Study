package com.home.StringTask;

import java.util.ArrayList;

public class StringTask2 {

    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String str = "!!day--yaz!!";
        String tmpStr="";
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i<str.length(); i++)
        {
            if (!alphabet.contains(str.substring(i, i + 1).toLowerCase())) {
                list.add(tmpStr.toLowerCase());
                tmpStr="";
            }
            else {tmpStr=tmpStr+str.substring(i,i+1);}
            if (i==str.length()-1)
            {
                list.add(tmpStr.toLowerCase());
            }
        }


        int count = 0;

        for(String i:list)
        {
            if (i.length()<2)
            {
                if (i.equals("y") || i.equals("z"))
                {
                    count++;
                }
            }
            else if (i.substring(i.length()-1, i.length()).equals("y") || i.substring(i.length()-1, i.length()).equals("z"))
            {
                count++;
            }
        }

        for(String i:list)
        {
            System.out.println(i);
        }

        System.out.println(count);


    }


}

