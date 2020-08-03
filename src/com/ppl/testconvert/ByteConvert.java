package com.ppl.testconvert;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class ByteConvert {
    public static class MeetingMemberRevamp implements Serializable {

        public MeetingMemberRevamp(String telNumber, int mixed, int tag) {
            byte[] temp = telNumber.getBytes(Charset.forName("utf-8"));
            System.arraycopy(temp, 0, TelNum, 0, temp.length > 20 ? 20 : temp.length);
            Mixed = mixed;
            Tag = tag;
            //byte[] bytes = Arrays.copyOfRange(temp, 0, 20);
        }

        public byte[] TelNum = new byte[20];

        public int Mixed;

        public int Tag;

        @Override
        public String toString() {
            String retStr = "";
            try {
                retStr = String.format("MeetingMemberRevamp TelNum:<%s> , Mixed: %d , Tag: %d "
                        , new String(TelNum, "utf-8"), Mixed, Tag);

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            return retStr;
        }
    }

    public static void main(String[] args) {
        String x = "13411415574";
        System.out.println(x);
        MeetingMemberRevamp member = new MeetingMemberRevamp(x, 1, 3);
        System.out.println(member.toString());
    }
}
