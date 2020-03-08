package com.home.SerializationTask;


import java.io.*;

public class SerializationTask7 {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address=(String) in.readObject();
            year = in.readInt();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException{
        Apartment apartment = new Apartment("sdsdsdsds" , 1963);
        FileOutputStream out = new FileOutputStream("C:/Users/Tex88/Desktop/apartment.dat");
        ObjectOutput objOut = new ObjectOutputStream(out);
        FileInputStream in = new FileInputStream("C:/Users/Tex88/Desktop/apartment.dat");
        ObjectInput objIn = new ObjectInputStream(in);
        apartment.writeExternal(objOut);
        objOut.close();
        out.close();
        Apartment apartment1 = new Apartment();
        apartment1.readExternal(objIn);
        System.out.println(apartment1.year);
    }

}
