package com.home.henfactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class HenFactory
{
    public Hen getHen(String country)
    {
            Hen hen;
            if (country.equals("Россия"))
            {
                hen = new RussianHen();

            }
            else if (country.equals("Украина"))
            {
                hen = new UkrainianHen();

            }
            else if (country.equals("Беларусь"))
            {
                hen = new BelarusianHen();

            }

            else if (country.equals("Молдова"))
            {
                hen = new MoldovanHen();

            }
            else hen=null;
            return hen;
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        point1: try {
            HenFactory factory = new HenFactory();
            Hen hen = factory.getHen("Украина");
            System.out.println(hen.getDescription());
            Hen hen1 = factory.getHen("Россия");
            System.out.println(hen1.getDescription());
            Hen hen2 = factory.getHen("ывывывы");
            System.out.println(hen2.getDescription());

        }
        catch (NullPointerException e)
        {
            System.out.println("Неверное название страны или куры из данной страны отсутсвуют");
        }



    }
}
