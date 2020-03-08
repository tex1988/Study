package com.home;

public class NotationTask1 {
    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        if (s.startsWith("0x")){
            int rawInt = Integer.parseInt(s.substring(2), 16);
            return Integer.toString(rawInt, 10);
        }
        else if (s.startsWith("0b")) {
            int rawInt = Integer.parseInt(s.substring(2), 2);
            return Integer.toString(rawInt, 10);
        }
        else if (s.startsWith("0")) {
            int rawInt = Integer.parseInt(s.substring(1), 8);
            return Integer.toString(rawInt, 10);
        }
        else return s;
    }
}
