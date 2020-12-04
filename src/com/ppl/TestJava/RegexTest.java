package com.ppl.TestJava;

import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        final String temp = getReplaceAll("134 0015 2256", "[^0-9]", "");
        //sout
        System.out.println(temp);
    }

    /*geti*/
    /*public static RegexTest getInstance() {
        return ;
    }*/

    public static String getReplaceAll(final String input,
                                       final String regex,
                                       final String replacement) {
        if (input == null) return "";
        return Pattern.compile(regex).matcher(input).replaceAll(replacement);
    }
}
