package com.home.InnerClassTask;

public class NestedClassTask1 {
    public static final String TEST = "test";

    public static class TEST {
        @Override
        public String toString() {
            return "test class";
        }
    }

    static Object obj;

    public static void main(String[] args) {
        obj = new TEST();
        System.out.println(obj);
    }
}
