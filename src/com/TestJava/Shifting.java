package com.TestJava;

public class Shifting {
    public static void main(String[] args) {
        System.out.println((Integer.MAX_VALUE << 8));
        System.out.println((Integer.MAX_VALUE >> 1));

        System.out.println(getTransTableHash(67108870, 1));
        System.out.println(getTransTableHash(67108870, 2));
    }


    private static long getTransTableHash(long deviceID, int channel) {
        long key = deviceID << 6;
        System.out.println("==Key:" + key);
        key += channel;//channel最多64,即6位
        System.out.println("==Key:" + key);
        return key;
    }
}
