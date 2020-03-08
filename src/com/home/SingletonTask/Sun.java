package com.home.SingletonTask;

public class Sun implements Planet
{
    private static Sun instance;

    private Sun() {
    }

    public static Sun getInsance() {
        if (instance == null) {
            instance = new Sun();
        }
        return instance;
    }
}
