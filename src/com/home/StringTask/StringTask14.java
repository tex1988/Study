package com.home.StringTask;

import java.util.ArrayList;
import java.util.Collections;

public class StringTask14 {

    public static String getLine(String string) {
        ArrayList<String> list = new ArrayList<>();
        String[] words = string.split(" ");
        Collections.addAll(list, words);
        StringBuilder sb = new StringBuilder();
        /*sb.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            String line = sb.toString().trim();
            if (line.substring(line.length()-1, line.length()).equalsIgnoreCase(list.get(i).substring(0,1))) {
                sb.append(" ");
                sb.append(list.get(i));
            }
            else if (line.substring(0,1).equalsIgnoreCase(list.get(i).substring(list.get(i).length()-1, list.get(i).length()))) {
                sb.insert(0,list.get(i)+" ");
            }
        }
        String[] words2 = sb.toString().split(" ");
        for (String i:words2) {
            for (int k=0; k<list.size();k++) {
                if (list.get(k).equals(i)) list.remove(k);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            String line = sb.toString().trim();
            if (line.substring(0,1).equalsIgnoreCase(list.get(i).substring(list.get(i).length()-1, list.get(i).length()))) {
                sb.insert(0,list.get(i)+" ");
            }
            else if (line.substring(line.length()-1, line.length()).equalsIgnoreCase(list.get(i).substring(0,1))) {
                sb.append(" ");
                sb.append(list.get(i));
            }
        }*/

        label: while (true) {
            Collections.shuffle(list);
            for (int i = 0; i < words.length; i++) {
                if (i==words.length-1) break label;
                else {
                    char last = list.get(i).toLowerCase().charAt(list.get(i).length() - 1);
                    char first = list.get(i + 1).toLowerCase().charAt(0);
                    if (last == first) {}
                    else continue label;
                }
            }
        }

        for (String i:list) {
            sb.append(i);
            sb.append(" ");
        }
        return sb.toString().trim();
    }


    public static void main(String[] args) {
        String string="Киев Нью-Йорк Амстердам Вена Мельбурн Владивосток";
        System.out.println(getLine(string));
    }
}
