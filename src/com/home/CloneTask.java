package com.home;

import java.util.LinkedHashMap;
import java.util.Map;

public class CloneTask {

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    @Override
    protected CloneTask clone() throws CloneNotSupportedException {
        CloneTask cloneTask = new CloneTask();
        for (Map.Entry <String, User> i:users.entrySet()) {
            cloneTask.users.put(i.getKey(), (User) i.getValue().clone());
        }
        return  cloneTask;
    }

    public static void main(String[] args) {
        CloneTask cloneTask = new CloneTask();
        cloneTask.users.put("Hubert", new User(172, "Hubert"));
        cloneTask.users.put("Zapp", new User(41, "Zapp"));
        CloneTask clone;
        try {
            clone = cloneTask.clone();
            System.out.println(cloneTask);
            System.out.println(clone);

            System.out.println(cloneTask.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }
}
