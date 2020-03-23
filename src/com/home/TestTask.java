package com.home;

public class TestTask {
    public static void main(String[] args){
        String str = "abc";
        int n=1;
        System.out.println(str.substring(n,str.length()));
        System.out.println(str.substring(0,n+1));
        System.out.println(str.substring(0,n)+(str.substring(n+1,str.length())));
        System.out.println(
                (str.substring(str.length()-1,str.length()))+
                str.substring(1,str.length()-1)+
                str.substring(0,1)
        );
        System.out.println(str.substring(0,3));
    }
}
