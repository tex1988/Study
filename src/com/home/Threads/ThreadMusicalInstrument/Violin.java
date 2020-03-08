package com.home.Threads.ThreadMusicalInstrument;

import java.util.Date;

public class Violin implements MusicalInstrument
{
    private String owner;

    public Violin(String owner) {
        this.owner = owner;
    }

    @Override
    public Date startPlaying() {
        System.out.println(this.owner + " starts playing");
        return new Date();
    }

    @Override
    public Date stopPlaying() {
        System.out.println(this.owner + " stops playing");
        return new Date();
    }

    @Override
    public void run() {
        Date start = startPlaying();
        sleepNSeconds(1);
        Date end = stopPlaying();
        System.out.println("Playing " + (end.getTime() - start.getTime()) + " ms");
    }

    public static void sleepNSeconds(int n){
        try {
            Thread.sleep(n*1000);
        }
        catch (InterruptedException e){e.printStackTrace();}
    }
}
