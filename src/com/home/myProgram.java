package com.home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;


public class myProgram
{
    static public int randomInt()
    {
        return (int)(Math.random()*100);
    }

    static void sortArray (int[] array)
    {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }

            }
            System.out.print(array[i] + " ");
        }

    }

    public static void main(String[] args)
    {

        int[] array = new int[20];
        for (int i=0; i<array.length; i++)
        {
            array[i]=randomInt();
        }

        for (Integer i:array)
        {
            System.out.print(i+" ");
        }

        System.out.print("\nЧетные: ");
        for (Integer i:array)
        {
            if (i%2==0){System.out.print(i+" ");}
        }

        System.out.print("\nНечетные: ");
        for (Integer i:array)
        {
            if (i%2!=0){System.out.print(i+" ");}
        }

        System.out.print("\nДелятся на 3 или на 9: ");
        for (Integer i:array)
        {
            if (i%3==0 || i%9==0){System.out.print(i+" ");}
        }

        System.out.print("\nДелятся на 5 и на 7: ");
        for (Integer i:array)
        {
            if (i%5==0 && i%7==0){System.out.print(i+" ");}
        }

        System.out.print("\nПузырек по убыванию: ");
        sortArray(array);
        System.out.print("\nДвухзначные с одинаковыми числами: ");
        for (Integer i:array)
        {
            if (i%10==i/10)
            {
                System.out.print(i+" ");
            }
        }

        System.out.print("\nЧисла Фибоначчи: ");
        int[] array2 = new int [10];
        array2[0]=1;
        array2[1]=1;
        System.out.print(array2[0]+" "+array2[1]+" ");
        for (int i=2; i<10; i++)
        {
            array2[i]=array2[i-2]+array2[i-1];
            System.out.print(array2[i]+" ");
        }


        PegasusTask.Pegasus pegasus = new PegasusTask.Pegasus();
        pegasus.fly(3,9,20);
    }



}