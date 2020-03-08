package com.home.StreamTasks;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StreamTask18 {

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

    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

        File file = new File("C:/Users/Tex88/Desktop/"+args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        String line;
        Date birthDate;
        String name="";
        String numRegex   = ".*[0-9].*";

        while ((line=reader.readLine())!=null) {
            for (int i=0; i<line.length()-1; i++) {
                if(line.substring(i,i+1).matches(numRegex)) {
                    birthDate=dateFormat.parse(line.substring(i, line.length()));
                    PEOPLE.add(new Person(name, birthDate));
                    name="";
                    break;
                }
                else {name = name + line.substring(i, i + 1);}
            }

        }
        reader.close();
        System.out.println(PEOPLE.get(1));
    }
}
