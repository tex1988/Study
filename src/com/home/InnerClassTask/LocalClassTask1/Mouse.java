package com.home.InnerClassTask.LocalClassTask1;

/*
обратите внимание, как именно Mouse отличается от Cat
Этот класс - привычный для вас.
*/
public class Mouse implements Pet, Sayable {
    @Override
    public Sayable toSayable(int i) {
        return this;
    }

    @Override
    public String say() {
        return "Мыша пищит.";
    }
}
