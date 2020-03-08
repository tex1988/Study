package com.home.Threads;

import java.util.ArrayList;
import java.util.List;

public class ThreadTask3
{
    public static class SpecialThread implements Runnable
    {
        @Override
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }

    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args)
    {
        SpecialThread thread1 = new SpecialThread();
        SpecialThread thread2 = new SpecialThread();
        SpecialThread thread3 = new SpecialThread();
        SpecialThread thread4 = new SpecialThread();
        SpecialThread thread5 = new SpecialThread();

        list.add(new Thread(thread1));
        list.add(new Thread(thread2));
        list.add(new Thread(thread3));
        list.add(new Thread(thread4));
        list.add(new Thread(thread5));

        for (Thread i:list)
        {
            i.run();
        }
    }



}
