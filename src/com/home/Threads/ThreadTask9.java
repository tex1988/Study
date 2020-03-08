package com.home.Threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadTask9 {

        public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public static class Read3Strings extends Thread {

            private String a,b,c;

            @Override
            public void run(){

                try {
                    a=reader.readLine();
                    b=reader.readLine();
                    c=reader.readLine();
                }
                catch (IOException e){}
            }

            public String getString() {
               return  a+" "+b+" "+c;
            }
        }

        public static void main(String[] args) throws InterruptedException{
            Read3Strings thread1 = new Read3Strings();
            Read3Strings thread2 = new Read3Strings();
            thread1.run();
            thread1.join();
            thread2.run();
            thread2.join();
            System.out.println(thread1.getString());
            System.out.println(thread2.getString());

        }

}
