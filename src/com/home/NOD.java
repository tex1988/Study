package com.home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NOD {

    public static int nod(int a, int b)
    {
        int nod;
        if (a%b==0)
        {
            nod=b;
            return nod;
        }
        else return nod(b, a%b);

    }

    public  static  void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        if (a>b) System.out.println(nod(a, b));
        else System.out.println(nod(b, a));


    }

}
