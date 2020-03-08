package com.home.StringTask;

public class StringTask11 {

    public static String getPartOfString(String string) throws TooShortStringException {
        int spaceCounter=0;
        for (int i=0; i<string.length(); i++) {
            if (string.substring(i, i+1).equals(" ")) {
                spaceCounter++;
            }
        }

        if (spaceCounter<4) {
            throw new TooShortStringException();
        }
        else {
            int start;
            int end = 0;
            int tmpIndex = 0;
            start = string.indexOf(" ") + 1;
            for (int i = 0; i < 5; i++) {
                end = string.indexOf(" ", tmpIndex) + 1;
                tmpIndex = string.indexOf(" ", tmpIndex) + 1;
            }
            return string.substring(start, end);
        }
    }

    public static class TooShortStringException extends Exception {}

    public static void main (String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }
}

