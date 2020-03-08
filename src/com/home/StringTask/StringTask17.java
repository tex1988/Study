package com.home.StringTask;

public class StringTask17 {

    public static  Boolean checkTelNumber(String telNumber ) {
        Boolean result;
        if (telNumber.replaceAll("\\D","").length()==12) {
            String regex="^\\+\\d*(\\(\\d{3}\\))?\\d*(-?\\d+)?-?\\d*\\d$";
            return telNumber.matches(regex);
        }
        else if (telNumber.replaceAll("\\D", "").length()==10) {
            String regex="\\d*(\\(\\d{3}\\))?\\d*(-?\\d+)?-?\\d*\\d$";
            return telNumber.matches(regex);
        }
        else
        return false;

    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("(063)250-86-45"));
    }
}
