package com.ppl.TestJava;

public class TimeUtilsTest {
    public static void main(String[] args) {
        System.out.println(TimeUtils.isToday(1596672100000l));

        System.out.println(TimeUtils.isYesterday(1596598910000l));
        System.out.println(TimeUtils.isBeforeYesterday(1596517033000l));
    }
}
