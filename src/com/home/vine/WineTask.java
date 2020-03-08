package com.home.vine;

public class WineTask
{
    public static Wine getWine ()
    {
        Wine wine = new Wine();
        return wine;
    }

    public static BubblyWine getBubblyWine ()
    {
        BubblyWine bubblyWine = new BubblyWine();
        return bubblyWine;
    }

    public static void main(String[] args)
    {
        Wine shabo = getWine();
        System.out.println(shabo.getHolidayName());
        shabo.taste();
        BubblyWine artemovskoe = getBubblyWine();
        System.out.println(artemovskoe.getHolidayName());
        artemovskoe.taste();

    }
}
