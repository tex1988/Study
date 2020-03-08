package com.home.StringTask;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;

public class StringTask7 {

    public static void main(String[] args)
    {
        String str="dfdffdfnnnnnghghghnnnghghllllllllllllll";
        int count=1;
        AbstractList<Integer> list = new ArrayList<Integer>();

        if (str.length()==0){list.add(0);}
        else {
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.substring(i, i + 1).equals(str.substring(i + 1, i + 2))) {
                    count++;
                    if (i == str.length() - 2) {
                        list.add(count);

                    }
                } else {
                    list.add(count);
                    count = 1;
                }
            }
        }

        Collections.sort(list);

        for (Integer i:list)
        {
            System.out.println(list);
        }


    }

}
