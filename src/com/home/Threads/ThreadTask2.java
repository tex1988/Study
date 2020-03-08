package com.home.Threads;

public class ThreadTask2 extends Thread
{
    static
    {
        System.out.println("it's static block inside TestThread");
    }
    @Override
    public void run()
    {
        System.out.println("it's run method");
    }

    public static void main(String[] args)
    {
        ThreadTask2 thread1 = new ThreadTask2();
        thread1.run();
    }
}
