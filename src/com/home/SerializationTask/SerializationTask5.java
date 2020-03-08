package com.home.SerializationTask;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializationTask5 {

    public static class Human implements Serializable {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
    }

    public static void main(String[] args) throws IOException{

        Human human = new Human("petrov", new Asset("car"), new Asset("home"));
        FileOutputStream out = new FileOutputStream("C:/Users/Tex88/Desktop/human.dat");
        ObjectOutputStream objectOut = new ObjectOutputStream(out);
        objectOut.writeObject(human);
        objectOut.close();
        out.close();

        Human human1 = new Human();
        FileInputStream in = new FileInputStream("C:/Users/Tex88/Desktop/human.dat");
        ObjectInputStream objectIn = new ObjectInputStream(in);
        try {
            human1 = (Human) objectIn.readObject();
        }
        catch (ClassNotFoundException e) {System.out.println("Класс не найден");}
        objectIn.close();
        in.close();
        System.out.println(human1.assets.get(0).getName());
    }
}
