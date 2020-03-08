package com.home.bridge;


public class Solution
{
    public static void println(Bridge bridge)
    {
        System.out.println(bridge.getCarsCount());
    }

    public static void main (String[] args)
    {
        WaterBridge waterBridge = new WaterBridge();
        SuspensionBridge susBridge = new SuspensionBridge();
        println(waterBridge);
        println(susBridge);
    }
}
