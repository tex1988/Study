package com.home.StringTask;

public class StingTask3 {

    public static void main(String[] args)
    {
        Boolean a=false;
        String str = "xxggxx";
        for (int i = 0; i<str.length(); i++)
        {
            if(str.length()==0)
            {
                a=false;
                break;
            }
            else if (str.length()==1)
            {
                if (str.equals("g"))
                {
                    a=false;
                    break;
                }
            }
            else if (str.substring(i,i+1).equals("g"))
            {
                if (i==0)
                {
                    if (str.substring(i,i+1).equals(str.substring(i+1,i+2)))
                    {
                        a=true;
                    }
                    else{a=false;}
                }
                else if (i==str.length()-1)
                {
                    if (str.substring(i,i+1).equals(str.substring(i-1,i)))
                    {
                        a=true;
                    }
                    else{a=false;}
                }
                else
                    {
                        if (str.substring(i,i+1).equals(str.substring(i+1,i+2)) || str.substring(i,i+1).equals(str.substring(i-1,i)))
                        {
                            a=true;
                        }
                        else{a=false;}
                    }
            }
        }

        System.out.println(a);
    }

}
