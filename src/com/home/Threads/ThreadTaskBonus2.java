package com.home.Threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ThreadTaskBonus2 {

        public static List<Thread> threads = new ArrayList<>();

        static
        {

            ThreadClass1 thread1 = new ThreadClass1();
            ThreadClass2 thread2 = new ThreadClass2();
            ThreadClass3 thread3 = new ThreadClass3();
            ThreadClass4 thread4 = new ThreadClass4();
            ThreadClass5 thread5 = new ThreadClass5();
            threads.add(thread1);
            threads.add(thread2);
            threads.add(thread3);
            threads.add(thread4);
            threads.add(thread5);
        }


        public interface Message {
        void showWarning();
        }

        static public class ThreadClass1 extends Thread {
            @Override
            public void run() {
                while (true)
                {

                }
            }
        }

        static public class ThreadClass2 extends Thread {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()){}
                    throw new InterruptedException();
                }

                catch (InterruptedException e){System.out.println(e.toString());}
            }
        }

        static public class ThreadClass3 extends Thread {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println("Ура");
                        Thread.sleep(500);
                    }
                }
                catch (InterruptedException e){}

            }
        }

        public static class ThreadClass4 extends Thread implements Message {
            @Override
            public void showWarning() {

                this.interrupt();

                try {
                    this.join();
                }
                catch (Exception e){}
            }

            @Override
            public void run() {
                while (!isInterrupted()){}
            }
        }

        public static class ThreadClass5 extends Thread {
            @Override
            public void run() {

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int b = 0;
                String a;
                try {
                    while (!(a=reader.readLine()).equals("N"))
                    {
                        b = b + Integer.parseInt(a);
                    }

                    System.out.println(b);
                    }
                catch (IOException e) {}
                catch (NumberFormatException e){System.out.println("Try again");run();}

            }
        }



        public static void main(String[] args) throws IOException, InterruptedException {

            new Thread(threads.get(4)).start();
            new Thread(threads.get(2)).start();



        }


}

