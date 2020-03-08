package com.home.Threads.ThreadMusicalInstrument;

public class Solution {

    public static void main(String[] args) {

        Thread violin = new Thread(new Violin("Player"));
        violin.start();

    }

}
