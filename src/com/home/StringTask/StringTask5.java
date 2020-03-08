package com.home.StringTask;

public class StringTask5 {

    public static void main(String[] args)
    {
        String digits = "0123456789";
        String str = "aa11b33";
        int sum=0;
        for (int i=0; i<str.length(); i++)
        {
            if (digits.contains(str.substring(i,i+1)))
            {
                sum=sum+Integer.parseInt(str.substring(i,i+1));
            }
        }

        System.out.println(sum);
    }

}
