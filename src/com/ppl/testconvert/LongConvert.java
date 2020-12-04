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
        List<Long> longs = getListStartTimes("1$2$4$5$6$7");
        int s;
    }
}
