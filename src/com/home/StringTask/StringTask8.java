package com.home.StringTask;

import java.util.ArrayList;

public class StringTask8 {

    public static void main(String[] args)
    {
        String digits = "0123456789";
        String str = "aa11b33";
        int sum=0;
        String tmpNum="";
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<str.length(); i++)
        {
            if (digits.contains(str.substring(i,i+1)))
            {
                tmpNum=tmpNum+str.substring(i,i+1);
                if(i==str.length()-1)
                {
                    list.add(Integer.parseInt(tmpNum));
                }

            }
            else
                {
                    if (tmpNum.equals("")){}
                    else {
                        list.add(Integer.parseInt(tmpNum));
                        tmpNum = "";
                        }
                }

        }

        for (Integer i:list)
        {
            sum=sum+i;
        }

        System.out.println(sum);
    }


}
