package com.home.StringTask;

public class StringTask2020 {
    public static void main(String[] args) {
        String str = "sds;ddelfgd;lkdfg";
        String del;
        String newStr;
        for (int i=0; i<str.length()-3; i++) {
            del=str.substring(i,i+3);
            if (del.equals("del")) {
                newStr = str.substring(0,i)+str.substring(i+3,str.length());
                System.out.println(newStr);
                break;
            }
        }
    }
}
