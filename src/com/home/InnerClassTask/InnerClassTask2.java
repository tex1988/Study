package com.home.InnerClassTask;

public class InnerClassTask2 {
    private String country;
    private String city;

    public InnerClassTask2(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getDescriptionOfUser(String name) {
        return getTrickyUser(name).getDescription();
    }

    public SuperUser getTrickyUser(String name) {
        return new SuperUser(name);
    }

    private class SuperUser {
        private String name;

        public SuperUser(String name) {
            this.name = name;
        }

        public String getDescription() {
            return String.format("My name is %s. I'm from %s, %s.", this.name, InnerClassTask2.this.country, InnerClassTask2.this.city);
        }
    }

    public static void main(String[] args) {
        InnerClassTask2 solution = new InnerClassTask2("the USA", "Seattle");
        System.out.println(solution.getTrickyUser("George").getDescription());
        System.out.println(solution.getDescriptionOfUser("George"));
    }

}
