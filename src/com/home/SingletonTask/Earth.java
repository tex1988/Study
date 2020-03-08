package com.home.SingletonTask;

public class Earth implements Planet
{
    private static Earth instance;

    private Earth() {
    }

    public static Earth getInsance() {
        if (instance == null) {
            instance = new Earth();
        }
        return instance;
    }
}
