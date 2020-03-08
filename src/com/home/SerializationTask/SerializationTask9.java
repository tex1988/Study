package com.home.SerializationTask;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SerializationTask9 implements Serializable {

    public static void main(String[] args) {
        File file = new File("C:/Users/Tex88/Desktop/task.dat");
        SerializationTask9 savedObject = new SerializationTask9(4);
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(savedObject);
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            SerializationTask9 loadedObject = (SerializationTask9) objIn.readObject();
            if (loadedObject.string.equals(savedObject.string)) {
                System.out.println("All right");
            }
            else {System.out.println("Something wrong");}
        }
        catch (FileNotFoundException e) {System.out.println("File not found");}
        catch (IOException e) {System.out.println("Some IO error");}
        catch (ClassNotFoundException e) {System.out.println("Class not found");}
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private Date currentDate;
    private int temperature;
    String string;

    public SerializationTask9() {}

    public SerializationTask9(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;
        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
