package com.home;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompareTask {

    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return type.toString()+" "+line+"\n";
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static void main(String[] args) throws IOException {

        File file1 = new File("C:/Users/Tex88/Desktop/"+args[0]+".txt");
        File file2 = new File("C:/Users/Tex88/Desktop/"+args[1]+".txt");
        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        String line;
        while ((line=reader1.readLine())!=null) {
            list1.add(line);
        }
        reader1.close();
        while ((line=reader2.readLine())!=null) {
            list2.add(line);
        }
        reader2.close();

        for (String i:list1) {
            if (list2.contains(i)) {
                lines.add(new LineItem(Type.SAME, i));
            }
            else {lines.add(new LineItem(Type.REMOVED, i));}
        }
        for (String i:list2) {
            if (!list1.contains(i)) {
                lines.add(new LineItem(Type.ADDED, i));
            }
        }

        System.out.println(lines);

    }

}
