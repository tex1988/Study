package com.home;

import java.io.IOException;
import java.util.LinkedList;


public class NumbersTask {

    public static LinkedList<Long> getNumbers(Long number) {
        long n =number;
        LinkedList<Long> list = new LinkedList<>();
        for (Long s=0L; s<n; s++) {
            long solve=0;
            for (int i=0; i<s.toString().length(); i++){
                solve=solve+(long) Math.pow((double)Integer.parseInt(s.toString().substring(i,i+1)), (double) (s.toString().length()));
            }
            if (s==solve) {list.add(solve);}
        }
        return list;
    }

    public static void main(String[] args) throws IOException{

        long memoryStart = Runtime.getRuntime().freeMemory();
        Long t0 = System.currentTimeMillis();
        LinkedList<Long> list = getNumbers(2147483647L);
        long memoryEnd = Runtime.getRuntime().maxMemory();
        long memoTaken = memoryStart - memoryEnd;
        System.out.println(memoTaken);
        Long t1 = System.currentTimeMillis();
        System.out.println("Time need to create the arrray = " + (t1 - t0));
        System.out.println("Used Memory in JVM: " + (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()));
    }

}
