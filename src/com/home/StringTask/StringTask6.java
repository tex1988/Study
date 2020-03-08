package com.home.StringTask;

public class StringTask6 {

    public static void main(String[] args)
    {
        String string ="x";
        String str="";
        Boolean allEquals=true;

        for (int i=0; i<string.length()-1; i++)
        {
            if (!string.substring(i,i+1).equals(string.substring(i+1,i+2)))
            {
                allEquals=false;
                break;
            }
        }

        if (allEquals)
        {
            str=string.substring(0, string.length()/2);
        }
        else {
            for (int i = 1; i < string.length(); i++) {
                if (string.substring(i, i + 1).equals(string.substring(0, 1))) {
                    str = string.substring(0, i);
                    for (int k = str.length(); k > 0; k--) {
                        if (str.substring(k - 1, k).equals(string.substring(string.length() - 1, string.length()))) {
                            str = string.substring(0, k);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(str);
    }

}
