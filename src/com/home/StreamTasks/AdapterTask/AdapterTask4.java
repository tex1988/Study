package com.home.StreamTasks.AdapterTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AdapterTask4 {

    public static class Person {
        private String name;
        private Date birthDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");

        public Person(String name, Date birthDate) {
            this.name = name;
            this.birthDate = birthDate;
        }

        public String getName() {
            return name;
        }
        public Date getBirthDate() {
            return birthDate;
        }

        public void setName(String name) {
            this.name = name;
        }
        public void setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
        }

        @Override
        public String toString() {
            return this.name+" "+dateFormat.format(this.birthDate);
        }
    }

    public interface PersonScanner {
        public Person read() throws ParseException;
        public void close() throws IOException;
    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws ParseException {

            try {
                String name = scanner.next()+" "+scanner.next()+" "+scanner.next();
                SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
                Date birthDate = dateFormat.parse(scanner.next()+scanner.next()+scanner.next());
                return new Person(name, birthDate);
            }
            catch (NoSuchElementException e) {
                Date errorDate = new Date();
                return new Person("Запись отсутсвует", errorDate);}
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }


    public static void main(String[] args) throws FileNotFoundException, ParseException{
        File file = new File ("C:/Users/Tex88/Desktop/File.txt");
        Scanner scanner = new Scanner(file);
        PersonScannerAdapter personScanner = new PersonScannerAdapter(scanner);
        System.out.println(personScanner.read());
        System.out.println(personScanner.read());
        System.out.println(personScanner.read());
        System.out.println(personScanner.read());
    }
}
