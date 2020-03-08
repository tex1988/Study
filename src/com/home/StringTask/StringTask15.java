package com.home.StringTask;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringTask15 {
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        List<String> words = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens())
            words.add(stringTokenizer.nextToken());
        String[] stringArray = new String[words.size()];
        for (int i = 0; i < stringArray.length; i++)
            stringArray[i] = words.get(i);
        return stringArray;
    }

    public static void main(String[] args) {

        String [] test = getTokens("level22.lesson13.task01", ".");
        for (String i:test) {
            System.out.println(i);
        }
    }
}
