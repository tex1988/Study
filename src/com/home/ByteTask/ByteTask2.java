package com.home.ByteTask;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ByteTask2 {

    public static void main(String[] args) {
        int modifiersOfThisClass = ByteTask2.class.getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.ABSTRACT));

        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true
    }

    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {
        int a = allModifiers  & specificModifier;
        if (a==specificModifier) return true;
        else return false;
    }

    private static Method getMainMethod() {
        Method[] methods = ByteTask2.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }
        return null;
    }
}
