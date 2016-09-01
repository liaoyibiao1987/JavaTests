package com.ppl.javaIO.keyword;

import java.io.*;
import java.util.*;

/*���磬����һ��Login �����������һ���ض��ĵ�¼�Ự�йص���Ϣ��У���¼�ĺϷ���ʱ��һ�㶼�뽫��
�ݱ��������������������롣Ϊ������һ�㣬��򵥵İ취��ʵ��Serializable������ password �ֶ���Ϊtransient��*/

public class Logon implements Serializable {
	private Date date = new Date();
	private String username;

	// private String password;
	private transient String password;

	Logon(String name, String pwd) {
		username = name;
		password = pwd;
	}

	public String toString() {
		String pwd = (password == null) ? "(n/a)" : password;
		return "logon info: \n " + "username: " + username + "\n date: " + date.toString() + "\n password: " + pwd;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logon a = new Logon("Hulk", "myLittlePony");
		System.out.println("logon a = " + a);
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Logon.out"));
			o.writeObject(a);
			o.close();
			// Delay:
			/*
			 * int seconds = 5; long t = System.currentTimeMillis() + seconds *
			 * 1000; while (System.currentTimeMillis() < t) ;
			 */
			Thread.sleep(2000);
			// Now get them back:
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
			System.out.println("Recovering object at " + new Date());
			a = (Logon) in.readObject();
			System.out.println("logon a = " + a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
