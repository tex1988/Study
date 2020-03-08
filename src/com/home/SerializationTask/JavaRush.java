package com.home.SerializationTask;


import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public  class JavaRush implements Serializable {
    public List<User> users = new ArrayList<>();
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

    public void save(OutputStream outputStream) throws Exception {
        PrintWriter writer = new PrintWriter(outputStream);
        for (User i : users) {
            writer.println(dateFormat.format(i.getBirthDate()));
            writer.println(i.getFirstName());
            writer.println(i.getLastName());
            writer.println(i.getMale());
            writer.println(i.getCountry());
            writer.flush();
        }
        writer.close();
    }

    public void load(InputStream inputStream) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String birthDate;
        String firstName;
        String lastName;
        String male;
        String country;
        int userCounter=0;
        while ((birthDate=reader.readLine())!=null &&
                (firstName=reader.readLine())!=null &&
                (lastName=reader.readLine())!=null &&
                (male=reader.readLine())!=null &&
                (country=reader.readLine())!=null) {
            users.add(new User());
            users.get(userCounter).setBirthDate(dateFormat.parse(birthDate));
            users.get(userCounter).setFirstName(firstName);
            if (lastName.equals("null")) {users.get(userCounter).setLastName(null);}
            else {users.get(userCounter).setLastName(lastName);}
            if (male.equals("true")) {users.get(userCounter).setMale(true);}
            else {users.get(userCounter).setMale(false);}
            users.get(userCounter).setCountry(User.Country.valueOf(country));
            userCounter++;
        }
        reader.close();
    }
}
