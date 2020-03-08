package com.home.SerializationTask;

import java.io.Serializable;

public class SerializationTask10 implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;

    public SerializationTask10(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
    }


}
