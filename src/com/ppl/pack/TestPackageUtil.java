package com.ppl.pack;

import java.io.IOException;
import java.util.List;

public class TestPackageUtil {
    public static void main(String[] args) {
        PackageUtil util = new PackageUtil();
        util.setOnReceivedFullBufferHandler((obj) -> {
            onReceivedFullBuffer(obj);
        });

        byte[] data = new byte[2500];
        for (int i = 0; i < 2500; i++) {
            data[i] = (byte) (i % 10);
        }

        List<byte[]> datas = PackageUtil.unpack(data);
        for (byte[] item : datas) {
            util.pack(123456, 789, "112.91.151.186:5007", item);
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void onReceivedFullBuffer(FullPackage obj) {
        System.out.println("onReceivedFullBuffer" + obj.toString());
    }
}
