package com.home;


class Recursion
{
    public  static void f (int arg)
    {
        System.out.println(" "+arg);
        if (arg<7){f(2*arg);}
        System.out.println(" "+arg);
    }

    public static int fib (int arg)
    {
        if (arg==0){return 1;}

        else if (arg==1){return 1;}
        else
        {
            return fib(arg-2)+fib(arg-1);
        }
    }

    public static void factorial(int a)
    {
        System.out.println(a+"!="+subFactorial(a));
    }

    public static int subFactorial(int b)
    {
        if (b==0){return 0;}
        else if (b==1) {return 1;}
        else {return b*subFactorial(b-1);}
    }

    public static void main (String[] args)
    {
        /*f(1);
        System.out.println(fib(6));*/

        factorial(1);
    }
}
