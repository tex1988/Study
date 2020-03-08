package com.home.NotationTask2;

/* Конвертер систем счислений
Реализуйте логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit()
из одной системы счисления(numerationSystem) в другую (expectedNumerationSystem)
бросьте NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2
Валидация для - number.getDigit() - целое не отрицательное
Метод main не участвует в тестировании
*/

public class NotationTask2 {
    public static void main(String[] args) {
        //Number number = new Number(NumerationSystemType._2, "11010010000000");
        Number number = new Number(NumerationSystemType._10, "1545451515");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._16);
        System.out.println(result);    //expected 110
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        Integer rawInt = Integer.parseInt(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());
        String digit = Integer.toString(rawInt, expectedNumerationSystem.getNumerationSystemIntValue());
        return new Number(expectedNumerationSystem, digit);
    }
}
