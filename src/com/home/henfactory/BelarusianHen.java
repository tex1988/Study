package com.home.henfactory;

public class BelarusianHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth() {
        return 90;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+" Моя страна Бульбастан. Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }

}
