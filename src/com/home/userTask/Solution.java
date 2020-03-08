package com.home.userTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    static void doWork(Person person)
    {
        if (person instanceof Person.User)
        {
            ((Person.User) person).live();
        }
        else if (person instanceof Person.Looser)
        {
            ((Person.Looser) person).doNothing();
        }
        else if (person instanceof Person.Coder)
        {
            ((Person.Coder) person).coding();
        }
        else if (person instanceof Person.Proger)
        {
            ((Person.Proger) person).enjoy();
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = reader.readLine();
        Person person = null;
        if (key.equals("User"))
        {
            person = new Person.User();
        }
        else if (key.equals("Looser"))
        {
            person = new Person.Looser();
        }
        else if (key.equals("Coder"))
        {
            person = new Person.Coder();
        }
        else if (key.equals("Proger"))
        {
            person = new Person.Proger();
        }
        doWork(person);
    }
}
