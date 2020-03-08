package com.home.henfactory;


public class RussianHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth() {
        return 10;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+" Моя страна Рашкапидарашка. Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
