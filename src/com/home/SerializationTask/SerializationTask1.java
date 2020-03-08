package com.home.SerializationTask;

import java.io.*;

public class SerializationTask1 {

    public static void main(String[] args) {

        try {
            File file = new File("C:/Users/Tex88/Desktop/File3.txt");
            OutputStream outputStream = new FileOutputStream(file);
            InputStream inputStream = new FileInputStream(file);

            Human ivanov = new Human("Ivanov", new Asset("car"), new Asset("home"));
            ivanov.assets.get(0).setPrice(1000.132);
            ivanov.assets.get(1).setPrice(100000);
            System.out.println(ivanov.assets.toString());
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            System.out.println(somePerson.assets.toString());

        } catch (IOException e) {
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            System.out.println("Oops, something wrong with save/load method");
        }
    }
}
