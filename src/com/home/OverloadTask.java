package com.home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OverloadTask {

    public static void print(short a){System.out.println(a);}
    public static void print(int a){System.out.println(a);}
    public static void print(double a){System.out.println(a);}

    public static void main (String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String a=reader.readLine();
            if (a.equals("exit")){break;}
            else if (a.contains("."))
            {
                double b=Double.parseDouble(a);
                print(b);
            }

            else if (Integer.parseInt(a)>128)
            {
                int b=Integer.parseInt(a);
                print(b);
            }

            else if (Integer.parseInt(a)<128)
            {
                short b=Short.parseShort(a);
                print(b);
            }

        }
    }
}
