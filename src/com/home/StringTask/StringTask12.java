package com.home.StringTask;

public class StringTask12 {

    public static String getPartOfString(String string) throws TooShortStringException {
        int spaceCounter=0;
        for (int i=0; i<string.length(); i++) {
            if (string.substring(i, i+1).equals("\t")) {
                spaceCounter++;
            }
        }

        if (spaceCounter<2) {
            throw new TooShortStringException();
        }
        else {
            int start;
            int end = 0;
            int tmpIndex = 0;
            start = string.indexOf("\t") + 1;
            for (int i = 0; i < 2; i++) {
                end = string.indexOf("\t", tmpIndex) + 1;
                tmpIndex = string.indexOf("\t", tmpIndex) + 1;
            }
            return string.substring(start, end);
        }
    }

    public static class TooShortStringException extends Exception {}

    public static void main (String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttabsdsdsddsd\ttab1\t"));       //tab
    }
}
