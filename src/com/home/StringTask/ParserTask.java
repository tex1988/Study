package com.home.StringTask;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParserTask
{
    public static LinkedHashMap<String, String> Parser (String link)
    {

        String linkParams="";
        String tmpParam="";
        StringBuilder stb;
        LinkedHashMap<String, String> paramMap = new LinkedHashMap<>();

        for (int i=0; i<link.length(); i++)
        {
            if (link.substring(i,i+1).equals("?"))
            {
                linkParams=link.substring(i+1, link.length());
                break;
            }
        }

        for (int i=0; i<linkParams.length(); i++)
        {
            if (linkParams.substring(i,i+1).equals("&"))
            {
                for(int k=0; k<tmpParam.length(); k++)
                {
                    if (tmpParam.substring(k, k+1).equals("="))
                    {
                        paramMap.put(tmpParam.substring(0, k), tmpParam.substring(k+1, tmpParam.length()));
                        tmpParam=tmpParam.substring(0, k);
                    }
                    else if (!tmpParam.contains("=")){paramMap.put(tmpParam, null);}
                }
                tmpParam="";
            }
            else{tmpParam=tmpParam+linkParams.substring(i,i+1);}

            if (i==linkParams.length()-1)
            {
                for(int k=0; k<tmpParam.length(); k++)
                {
                    if (tmpParam.substring(k, k+1).equals("="))
                    {
                        paramMap.put(tmpParam.substring(0, k), tmpParam.substring(k+1, tmpParam.length()));
                        tmpParam=tmpParam.substring(0, k);
                    }
                    else if (!tmpParam.contains("=")){paramMap.put(tmpParam, null);}
                }
            }

        }

        for (Map.Entry<String, String> i:paramMap.entrySet())
        {
            if (i.getKey().equals("obj"))
            {
                if (i.getValue().contains(".")){printObject(Double.parseDouble(i.getValue()));}
                else {printObject(i.getValue());}

            }
        }
        return paramMap;
    }

    public static void printObject (String objValue)
    {
        System.out.println("String "+objValue);
    }

    public static void printObject (Double objValue)
    {
        System.out.println("Double "+objValue);
    }


    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String link = reader.readLine();
        LinkedHashMap<String, String> paramMap = new LinkedHashMap<>(Parser(link));

        for (Map.Entry<String, String> i:paramMap.entrySet())
        {
            System.out.println(i.getKey()+" "+i.getValue());
        }

    }
}
