package com.home.LogicOperatorsTask1;


import java.util.concurrent.ForkJoinPool;

public class LogicOperatorsTask1 {
    /* Fork/Join
    1. Создайте класс BinaryRepresentationTask. Для этого на красном имени класса нажмите Alt+Enter -> Create Class ...
    (класс должен наследоваться от RecursiveTask)
    2. Реализуйте логику метода compute, должна переводить число в двоичное представление.
    3. Используйте методы fork и join.
    4. Пример функциональной реализации - метод binaryRepresentationMethod.
    */

    private String binaryRepresentationMethod(int x) {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            return binaryRepresentationMethod(b) + result;
        }
        return result;
    }

    public static void main(String[] args) {
        LogicOperatorsTask1 logicOperatorsTask1 = new LogicOperatorsTask1();
        String result1 = logicOperatorsTask1.binaryRepresentationMethod(116);
        System.out.println(result1);

        System.out.println();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        String result2 = (String)forkJoinPool.invoke(new BinaryRepresentationTask(116));
        System.out.println(result2);
    }
}
