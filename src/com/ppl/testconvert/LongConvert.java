package com.ppl.testconvert;

import java.util.ArrayList;
import java.util.List;

public class LongConvert {
    public static List<Long> getListStartTimes(String listStartTimes) {
        if (listStartTimes != null) {
            String[] split = listStartTimes.split("$");
            List<Long> ret = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                try {
                    long p = Long.parseLong(split[i]);
                    ret.add(p);
                } catch (Exception es) {
                    es.printStackTrace();
                }
            }
            return ret;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        //List<Long> longs = getListStartTimes("1$2$4$5$6$7");
        long x = Long.valueOf("8618023066709");
        int i1 = Character.codePointAt("A我四一个个并", 0);
        int i2 = Character.codePointAt("S我四一个个并", 0);
        int s;
    }
}
