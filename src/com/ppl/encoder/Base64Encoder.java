package com.ppl.encoder;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Base64;

public class Base64Encoder {
	 static final String base64Str = "eyJjb21tYW5kIjoiMiIsImRhdGEiOnsibGl2ZUluZm8iOm51bGwsImRvY2lkIjoiRkhJT09HTEMwMDAxOEFQMSIsInNvdXJjZSI6IueOr+eQg+e9kSIsInRpdGxlIjoi54m55pyX5pmuOuaIkeS7rOWKneS6huW+iOWkmuWbveWutuemgeeUqOWNjuS4uiDlpKfpg6jliIbmmK/miJHlip3nmoQiLCJwcmlvcml0eSI6IjEwMSIsImhhc0ltZyI6IjEiLCJ1cmwiOiJodHRwczovLzNnLjE2My5jb20vbmV3cy8yMC8wNzE1LzEwL0ZISU9PR0xDMDAwMThBUDEuaHRtbCIsImNvbW1lbnRDb3VudCI6IjYwODI0IiwiaW1nc3JjM2d0eXBlIjoiMSIsInN0aXRsZSI6IiIsImRpZ2VzdCI6IuOAkOeOr+eQg+e9keaKpemBk+OAkeeJueacl+aZruaenOeEtuaJv+iupOS6huOAgueJueacl+aZruWcqOeZveWuq+eOq+eRsOWbreiusuivneinhumikeaIqiIsImltZ3NyYyI6Imh0dHA6Ly9jbXMtYnVja2V0LndzLjEyNi5uZXQvMjAyMC8wNzE1LzE1MzFhZjZicDAwcWRoc3oxMDBraWMwMDBzNjAwZTNjLnBuZyIsInB0aW1lIjoiMjAyMC0wNy0xNSAxMDoxODo0NyJ9fQ==";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		base64Decode(base64Str);
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
