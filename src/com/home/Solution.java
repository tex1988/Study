package com.home;


import java.io.IOException;


public class Solution {

    public static void main(String... args) throws IOException {

            Example result = null;
            String s = "a";
            switch (s) {
                case "a": {
                    result = new Solution().new A();
                    break;
                }
                case "b": {
                    result = new Solution().new B();
                    break;
                }
                case "c": {
                    result = new Solution().new C();
                    break;
                }
            }
            if (result instanceof C) {
                C p = (C) result;
                System.out.println(p.getClass().getSimpleName());
            }
        }

    interface Example {
    }
    class A implements Example {
        {
            System.out.println("it's A class");
        }
    }
    class B implements Example {
        {
            System.out.println("it's B class");
        }
    }
    class C extends A {
        {
            System.out.println("it's C class");
        }
    }
}

