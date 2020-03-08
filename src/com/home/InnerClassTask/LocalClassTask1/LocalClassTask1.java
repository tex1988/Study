package com.home.InnerClassTask.LocalClassTask1;

import java.util.List;

/* Реализация интерфейса используя локальный класс
В классе Cat реализуйте логику метода toSayable, которая описана в джавадоке.
*/
public class LocalClassTask1 {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}