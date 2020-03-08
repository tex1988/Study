package com.home.SerializationTask;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class SerializationTask6 {

    public static void main(String[] args) throws ParseException, IOException{
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        JavaRush javaRush = new JavaRush();

        User user1 = new User();
        user1.setBirthDate(dateFormat.parse("21.01.2000"));
        user1.setCountry(User.Country.RUSSIA);
        user1.setFirstName("Kolea");
        user1.setLastName("Golubkov");
        user1.setMale(true);

        User user2 = new User();
        user2.setBirthDate(dateFormat.parse("14.03.1995"));
        user2.setCountry(User.Country.OTHER);
        user2.setFirstName("Masha");
        user2.setLastName(null);
        user2.setMale(false);

        javaRush.users.add(user1);
        javaRush.users.add(user2);

        FileOutputStream out = new FileOutputStream("C:/Users/Tex88/Desktop/javaRush.dat");
        ObjectOutputStream objectOut = new ObjectOutputStream(out);
        objectOut.writeObject(javaRush);
        objectOut.close();
        out.close();

        JavaRush javaRush1 = new JavaRush();
        FileInputStream in = new FileInputStream("C:/Users/Tex88/Desktop/javaRush.dat");
        ObjectInputStream objectIn = new ObjectInputStream(in);
        try {
            javaRush1= (JavaRush) objectIn.readObject();
        }
        catch (ClassNotFoundException e) {System.out.println("Класс не найден");}
        System.out.println(javaRush1.users.get(1).getFirstName());
    }
}
