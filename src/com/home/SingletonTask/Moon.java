package com.home.SingletonTask;

public class Moon implements Planet
{
    private static Moon instance;

    private Moon() {
    }

    public static Moon getInsance() {
        if (instance == null) {
            instance = new Moon();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Moon{}";
    }
}
