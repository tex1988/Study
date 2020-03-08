package com.home.ByteTask;

public class ByteTask1 {

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAddress = new byte[ip.length];
        for (int i = 0; i < netAddress.length; i++)
            netAddress[i] = (byte)(ip[i] & mask[i]);
        return  netAddress;
    }

    public static void print(byte[] bytes) {
        for (byte i:bytes) {
            System.out.print(String.format("%8s", Integer.toBinaryString(i & 0xFF)).replace(' ', '0')+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);
        print(mask);
        print(netAddress);
    }

}
