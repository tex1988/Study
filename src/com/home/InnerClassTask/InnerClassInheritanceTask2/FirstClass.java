package com.home.InnerClassTask.InnerClassInheritanceTask2;

public abstract class FirstClass implements Action {     //first implementation

    protected FirstClass() {
        InnerClassInheritanceTask2.countActionObjects++;
    }

    public void someAction() {
        System.out.println("class FirstClass, method someAction");
    }

    public abstract Action getDependantAction();
}
