package com.home;

import java.io.*;
import java.util.ArrayList;

public class CryptoTask {

        public static File encrypt (File inputFile) {

            File outputFile = new File("C:/Users/Tex88/Desktop/encrypted_"+inputFile.getName());

            try {
                DataInputStream in = new DataInputStream(new FileInputStream(inputFile));
                ArrayList<Integer> byteBuffer = new ArrayList<>();
                while (in.available()>0) {
                    byteBuffer.add(in.read());
                }
                in.close();

                for (int i=0; i<byteBuffer.size(); i++) {
                    if (byteBuffer.get(i)<250 && byteBuffer.get(i)>4) {
                        byteBuffer.set(i, (byteBuffer.get(i)-3));
                    }
                }

                DataOutputStream out = new DataOutputStream(new FileOutputStream(outputFile));

                for (int i=0; i<byteBuffer.size(); i++) {
                    out.write(byteBuffer.get(i));
                }
                out.close();
            }
            catch (FileNotFoundException e) {System.out.println(e.toString());}
            catch (IOException e) {System.out.println(e.toString());}

            return outputFile;
        }

        public static File decrypt (File inputFile) {

            File outputFile = new File("C:/Users/Tex88/Desktop/decrypted_"+inputFile.getName());

            try {
                DataInputStream in = new DataInputStream(new FileInputStream(inputFile));
                ArrayList<Integer> byteBuffer = new ArrayList<>();
                while (in.available()>0) {
                    byteBuffer.add(in.read());
                }
                in.close();

                for (int i=0; i<byteBuffer.size(); i++) {
                    if (byteBuffer.get(i)<250 && byteBuffer.get(i)>4) {
                        byteBuffer.set(i, (byteBuffer.get(i)+3));
                    }
                }


                DataOutputStream out = new DataOutputStream(new FileOutputStream(outputFile));

                for (int i=0; i<byteBuffer.size(); i++) {
                    out.write(byteBuffer.get(i));
                }
                out.close();
            }
            catch (FileNotFoundException e) {System.out.println(e.toString());}
            catch (IOException e) {System.out.println(e.toString());}

            return outputFile;
        }


    public static void main(String[] args) {

        if (args[0].equals("e")) {
            File file = new File("C:/Users/Tex88/Desktop/"+args[1]);
            File encryptedFile = encrypt(file);
        }
        if (args[0].equals("d")) {
            File file = new File("C:/Users/Tex88/Desktop/"+args[1]);
            File decryptedFile = decrypt(file);
        }
    }
}
