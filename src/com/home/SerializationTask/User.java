package com.home.SerializationTask;


import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private Date birthDate;
    private String firstName;
    private String lastName;
    private Boolean male;
    private Country country;

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Boolean getMale() {
        return male;
    }

    public Country getCountry() {
        return country;
    }

    public  enum Country {
        RUSSIA,
        UKRAINE,
        OTHER
    }

    @Override
    public String toString() {
        return "User{" +
                "birthDate=" + birthDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", male=" + male +
                ", country=" + country +
                '}';
    }
}
