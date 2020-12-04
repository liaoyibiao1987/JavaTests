package com.TestJava;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TestGB12321 {
    public static void main(String[] args) {
        String x = "A我们的迹象";
        try {
            //byte[] tobyte = x.getBytes("gb2312");
            byte[] tobyte = new byte[50];
            String v = new String(tobyte, Charset.forName("gb2312"));
            System.out.println(v);

            String tel = "13411415574";
            char[] xx = tel.toCharArray();
            byte[] xy = tel.getBytes(Charset.defaultCharset());
            byte[] xs = getBytes("");

            System.out.println("===========");
            byte[] str = new byte[]{0x66, 0x18, 0x44};
            System.out.println(new String(str, "gbk"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] getBytes(String str) {
        return str.getBytes(Charset.defaultCharset());
    }
}
