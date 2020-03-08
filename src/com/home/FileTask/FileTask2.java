package com.home.FileTask;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTask2
{

    public static List<String> lines = new ArrayList<String>();
    public static void fileTask()
    {
        try
        {
            BufferedReader in = new BufferedReader(new FileReader("C:/Users/Tex88/Desktop/Constants.FILE_NAME"));

            String s;
            while ((s=in.readLine()) != null)
            {
                lines.add(s);
            }
            in.close();
            for (String i:lines)
            {
                System.out.println(i);
            }
        }
        catch (FileNotFoundException e){System.out.println(e);}
        catch (IOException e){}
    }

    public static void main (String[] args) throws FileNotFoundException, IOException
    {
            fileTask();

    }
}
