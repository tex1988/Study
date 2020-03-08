package com.home.henfactory;


public class UkrainianHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth() {
        return 150;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+" Моя страна великая Украина. Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
