package com.home.SerializationTask;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class SerializationTask2 {

    public static void main(String[] args) {

        try {
            File file = new File ("C:/Users/Tex88/Desktop/File3.txt");
            OutputStream outputStream = new FileOutputStream(file);
            InputStream inputStream = new FileInputStream(file);
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
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
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            outputStream.close();
            inputStream.close();
            System.out.println(loadedObject.users);

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

}
