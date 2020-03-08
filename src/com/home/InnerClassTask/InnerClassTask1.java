package com.home.InnerClassTask;


public class InnerClassTask1 {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static InnerClassTask1[] getTwoSolutions() {
        InnerClassTask1 mainClass1 = new InnerClassTask1();
        InnerClassTask1 mainClass2 = new InnerClassTask1();
        mainClass1.innerClasses[0] = mainClass1.new InnerClass();
        mainClass1.innerClasses[1] = mainClass1.new InnerClass();
        mainClass2.innerClasses[0] = mainClass2.new InnerClass();
        mainClass2.innerClasses[1] = mainClass2.new InnerClass();
        return new InnerClassTask1[]{mainClass1,mainClass2};
    }
}
