package com.home.StringTask;

public class StringTask4 {

    public static void main(String[] args)
    {
        String str="222abyyycdXXX";
        int count=0;
        for (int i=0; i<str.length()-2; i++)
        {
            if (str.substring(i,i+1).equals(str.substring(i+1,i+2)) && str.substring(i,i+1).equals(str.substring(i+2,i+3)))
            {
                count++;
            }
        }

        System.out.println(count);
    }

}
