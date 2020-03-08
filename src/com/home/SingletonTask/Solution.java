package com.home.SingletonTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static Planet thePlanet;

    public static void readKeyFromConsoleAndInitPlanet() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        if (a.equals(Planet.EARTH)){thePlanet = Earth.getInsance();}
        if (a.equals(Planet.SUN)){thePlanet = Sun.getInsance();}
        if (a.equals(Planet.MOON)){thePlanet = Moon.getInsance();}
    }

    public static void main (String[] args) throws IOException
    {
        readKeyFromConsoleAndInitPlanet();
        System.out.println(thePlanet);
    }
}
