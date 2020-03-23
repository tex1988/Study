package com.home.CRUD;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;


public class CrudTask {

    public static ArrayList<Person> list = new ArrayList<>();

    public synchronized static void crud (String[] args)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        try {
            if (args[0].equals("c")) {
                for (int i = 1; i < args.length - 1; i = i + 3) {
                    list.add(new Person(args[i], args[i + 1], dateFormat.parse(args[i + 2])));
                }
            }

            else if (args[0].equals("d")) {
                for (int i = 1; i < args.length; i++)
                    list.remove(Integer.parseInt(args[i]));
            }

            else if (args[0].equals("u")) {
                for (int i = 1; i < args.length - 3; i = i + 4) {
                    list.get(Integer.parseInt(args[i])).setName(args[i + 1]);
                    list.get(Integer.parseInt(args[i])).setSex(args[i + 2]);
                    list.get(Integer.parseInt(args[i])).setBirthDate(dateFormat.parse(args[i + 3]));
                }
            }

            else if (args[0].equals("i")) {
                for (int i = 1; i < args.length; i++) {
                    System.out.println(list.get(Integer.parseInt(args[i])));
                }
            }

            else {System.out.println("wrong key");}
        }
        catch (ParseException e){System.out.println("Wrong date format. Please use \"dd/MM/YYYY\" date format for birth date");}
    }

    public static void main(String[] args) {

        File f = new File("C:/Users/Tex88/Desktop/list.ser");

        try {
            if (f.exists()) {
                FileInputStream fis = new FileInputStream("C:/Users/Tex/Desktop/list.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                list = (ArrayList<Person>) ois.readObject();
                ois.close();
                }
            }
        catch (IOException e) {e.toString();}
        catch (ClassNotFoundException e) {e.toString();}

        crud(args);

        if (args[0].equals("c") || args[0].equals("d") || args[0].equals("u"))
        {
            try {
                FileOutputStream fos = new FileOutputStream("C:/Users/Tex/Desktop/list.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(list);
                oos.close();
                }
            catch (IOException e){}
        }
    }
}
