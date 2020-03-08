package com.home.henfactory;


public class MoldovanHen extends  Hen
{
    @Override
    int getCountOfEggsPerMonth() {
        return 2;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+" Моя страна Молдавия. Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
