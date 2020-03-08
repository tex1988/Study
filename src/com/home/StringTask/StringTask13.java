package com.home.StringTask;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StringTask13 {

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return first+" - "+second;
        }
    }

    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("C:/Users/Tex88/Desktop/" + reader.readLine() + ".txt");
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = fileReader.readLine()) != null) {
            sb.append(line + " ");
        }
        fileReader.close();
        ArrayList<String> tmp = new ArrayList<>();
        String[] words = sb.toString().trim().split(" ");

        StringBuilder sb1 = new StringBuilder(words[1]).reverse();
        String i = sb1.toString();
        sb1 = new StringBuilder(words[0]);
        String k = sb1.toString();
        if (k.equalsIgnoreCase(i)) {
            System.out.println("true");
        }
        else {System.out.println("false");}
        System.out.println(k);
        System.out.println(i);

        /*mainLoop: for (int i=0; i<words.length; i++) {
            sb = new StringBuilder();
            sb.append(words[i]);
            String reverseI = sb.reverse().toString();
            System.out.println(reverseI);
            for (int k=0; k<words.length; k++) {


                if (words[k].equals(reverseI)) {

                    result.add(new Pair(words[i], words[k]));
                    continue mainLoop;
                }
            }
        }*/
        System.out.println(tmp);
        System.out.println(result);
    }

}
