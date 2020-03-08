package com.home.Threads;


public class ThreadTask1 implements Runnable
{
    @Override
    public void run() {
        System.out.println("My first thread");
    }


    public static void main(String[] args)
    {
        ThreadTask1 thread1 = new ThreadTask1();
        thread1.run();
    }
}
