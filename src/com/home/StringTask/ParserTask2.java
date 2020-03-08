package com.home.StringTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class ParserTask2 {

    public static class Tag {
        String name;
        int beginIndex;
        int endIndex;

        public Tag(String name, int beginIndex, int endIndex) {
            this.name = name;
            this.beginIndex = beginIndex;
            this.endIndex = endIndex;
        }

        @Override
        public String toString() {
            return name+" ("+beginIndex+", "+endIndex+")";
        }
    }

    public static void main(String[] args) throws IOException {

        File file = new File ("C:/Users/Tex88/Desktop/File1.html");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        ArrayList<Tag> tagList = new  ArrayList<>();
        String tag=args[0];
        String line;
        String html="";

        //Read html file to one string
        while ((line=reader.readLine())!=null) {
            html=html+line;
        }
        reader.close();


        // Find start tag indexes
        for (int i=0; i<html.length()-tag.length()-1; i++) {
            if (html.substring(i, i+tag.length()+1).equals("<"+tag)) {
                tagList.add(new Tag(tag, i, 0));
            }
        }

        // Find end tag indexes
        for (Tag i:tagList) {
            int tagCounter=0;
            for (int k=i.beginIndex; k<html.length()-tag.length()-1; k++) {

                if (html.substring(k, k+tag.length()+1).equals("<"+tag)) {
                    tagCounter++;
                }
                if (html.substring(k, k+tag.length()+1).equals("/"+tag)) {
                    tagCounter--;
                    if (tagCounter==0) {
                        i.endIndex=k+tag.length()+2;
                        break;
                    }
                }
            }
        }

        for (Tag i:tagList) {
            System.out.println(html.substring(i.beginIndex, i.endIndex));
        }
    }
}
