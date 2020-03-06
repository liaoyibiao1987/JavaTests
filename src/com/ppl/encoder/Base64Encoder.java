package com.ppl.encoder;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Encoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		base64Decode("QURERFPlvpfmu7Tmu7Tmu7Tmu7TlpJrlpJo=");
	}
	
	
	/**
     * Return the bytes of decode Base64-encode string.
     *
     * @param input The input.
     * @return the string of decode Base64-encode string
     */
    public static void base64Decode(final String input) {
    	final Base64.Decoder decoder = Base64.getDecoder();
    	try {
			System.out.println(new String(decoder.decode(input), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
