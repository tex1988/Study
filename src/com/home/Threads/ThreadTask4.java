package com.home.Threads;


public class ThreadTask4
{
    public static class SpecialThread implements Runnable
    {
        @Override
        public void run() {
            for(StackTraceElement i:Thread.currentThread().getStackTrace())
            {
                System.out.println("main: "+i);
            }
        }
    }

    public static void main(String[] args) throws  InterruptedException
    {
        Thread thread1 = new Thread(new SpecialThread());
        thread1.start();
        thread1.join();
    }
}
