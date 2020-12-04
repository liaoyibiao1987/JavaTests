package com.ppl.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest {
    public static void main(String[] args) {
        List<String> x = new ArrayList<String>();
        x.add("AAA");
        x.add("BBB");
        System.out.println( Arrays.toString(x.toArray()));
    }
}
