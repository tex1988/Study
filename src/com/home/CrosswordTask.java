package com.home;

import java.util.ArrayList;

public class CrosswordTask {

    static class Word {
        String text;
        int startX;
        int startY;
        int endX;
        int endY;

        public Word(String text, int startX, int startY, int endX, int endY) {
            this.text = text;
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }
    }

    public static ArrayList<Word> detectAllWords(int[][] crossword, String... words) {

        ArrayList<Word> wordsList = new ArrayList<>();
        int horizontLength = crossword[0].length;
        int verticalLength = crossword.length;


        for (String s:words) {
            //По горизонтали
            for (int i=0; i<verticalLength; i++) {
                StringBuilder sb = new StringBuilder();
                for (int k=0; k<horizontLength; k++) {
                    sb.append(crossword[i][k]);
                    if (sb.toString().contains(s)) {
                        String linePart = sb.toString();
                        wordsList.add(new Word(s, linePart.indexOf(s), i, linePart.indexOf(s)+s.length()-1, i));
                    }
                    if (sb.reverse().toString().contains(s)) {
                        String linePart = sb.reverse().toString();
                        wordsList.add(new Word(s, horizontLength-linePart.indexOf(s)-1, i, horizontLength-linePart.indexOf(s)-s.length()-1,i));
                    }
                }
            }

            //По вертикали
            for (int i=0; i<horizontLength; i++) {
                StringBuilder sb = new StringBuilder();
                for (int[] k:crossword) {
                    sb.append(k[i]);
                    if (sb.toString().contains(s)) {
                        String linePart = sb.toString();
                        wordsList.add(new Word(s, linePart.indexOf(s), i, linePart.indexOf(s)+s.length()-1, i));
                    }
                    if (sb.reverse().toString().contains(s)) {
                        String linePart = sb.reverse().toString();
                        wordsList.add(new Word(s, horizontLength-linePart.indexOf(s)-1, i, horizontLength-linePart.indexOf(s)-s.length()-1,i));
                    }
                }
            }

            //Направо, вниз
            for (int i=0; i<verticalLength; i++) {
                for (int k=0; k<horizontLength; k++) {
                    int iTmp = i;
                    int kTmp = k;
                    StringBuilder sb = new StringBuilder();
                    while (iTmp<verticalLength && kTmp<horizontLength) {
                        sb.append(crossword[iTmp][kTmp]);
                        iTmp++;
                        kTmp++;
                    }
                    if (sb.toString().contains(s)) {
                        String linePart = sb.toString();
                        wordsList.add(new Word(s, k+linePart.indexOf(s), i+linePart.indexOf(s), k+linePart.indexOf(s)+s.length()-1, i+linePart.indexOf(s)+s.length()));
                    }
                    if (sb.reverse().toString().contains(s)) {
                        String linePart = sb.reverse().toString();
                        wordsList.add(new Word(s, kTmp-1-linePart.indexOf(s), iTmp-1-linePart.indexOf(s), kTmp-linePart.indexOf(s)-s.length(),iTmp-linePart.indexOf(s)-s.length()));
                    }
                }
            }

            //Влево, вниз
            /*for (int i=0; i<horizontLength; i++) {
                for (int k=horizontLength-1; k>=0; k--) {
                    int iTmp = i;
                    int kTmp = k;
                    StringBuilder sb = new StringBuilder();
                    while (iTmp<verticalLength && kTmp<horizontLength) {
                        sb.append(crossword[iTmp][kTmp]);
                        iTmp++;
                        kTmp--;
                    }
                    if (sb.toString().contains(s)) {
                        String linePart = sb.toString();
                        wordsList.add(new Word(s, linePart.indexOf(s), i+linePart.indexOf(s), linePart.indexOf(s)+s.length()-1, i));
                    }
                    if (sb.reverse().toString().contains(s)) {
                        String linePart = sb.reverse().toString();
                        wordsList.add(new Word(s, horizontLength-linePart.indexOf(s)-1, i, horizontLength-linePart.indexOf(s)-s.length()-1,i));
                    }
                }
            }*/

        }
        return wordsList;
    }

    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        System.out.println(detectAllWords(crossword, "darr"));
    }

}
