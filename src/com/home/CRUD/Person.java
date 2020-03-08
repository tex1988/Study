package com.home.CRUD;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Serializable{

    private String name;
    private String sex;
    private Date birthDate;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY");

    public Person(String name, String sex, Date birthDate) {
        this.name = name;
        this.sex = sex;
        this.birthDate=birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDate=" + dateFormat.format(birthDate)+
                '}';
    }


}
