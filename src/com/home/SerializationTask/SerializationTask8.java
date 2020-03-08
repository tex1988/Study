package com.home.SerializationTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationTask8 implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person person = new Person("Bart", "Simpson", 25);
        Person mom = new Person("Marge", "Simpson", 53);
        Person dad = new Person("Homer", "Simpson", 59);
        Person child1 = new Person("LittleBoy", "Simpson", 8);
        Person child2 = new Person("LittleGirl", "Simpson", 3);
        person.setFather(dad);
        person.setMother(mom);
        List<Person> list = new ArrayList<>();
        list.add(child1);
        list.add(child2);
        person.setChildren(list);

        System.out.println(person.firstName+" "+person.lastName+" "+person.age+" "+person.father.firstName+" "+person.mother.firstName+" "+person.children);

        File file = new File("C:/Users/Tex88/Desktop/person.dat");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(person);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Person newPerson = (Person) ois.readObject();
        ois.close();

        System.out.println(newPerson.firstName+" "+newPerson.lastName+" "+newPerson.age+" "+newPerson.father.firstName+" "+newPerson.mother.firstName+" "+newPerson.children);
    }

    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {}

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName=(String) in.readObject();
            lastName=(String) in.readObject();
            age=in.readInt();
            mother=(Person) in.readObject();
            father=(Person) in.readObject();
            children=(List<Person>) in.readObject();
        }
    }
}
