package com.ppl.javaIO;

import java.io.*;

class DirFilter implements FilenameFilter {
	String afn;

	DirFilter(String afn) {
		this.afn = afn;
	}

	@Override
	public boolean accept(File dir, String name) {
		// Strip path information:
		String f = new File(name).getName();
		return f.indexOf(afn) != -1;
	}
} /// :~

interface ITest {
	void test();
}

public class DirList {

	public static FilenameFilter filter(final String afn) {
		// Creation of anonymous inner class:
		return new FilenameFilter() {
			String fn = afn;

			public boolean accept(File dir, String n) {
				// Strip path information:
				String f = new File(n).getName();
				return f.indexOf(fn) != -1;
			}
		}; // End of anonymous inner class
	}

	public static ITest GetITest() {
		return new ITest() {
			
			@Override
			public void test() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File path = new File(".");
			String[] list;

			String filter = "fo?.b?r*";

			if (args.length == 0)
				list = path.list();
			else
				list = path.list(new DirFilter(args[0]));
			for (int i = 0; i < list.length; i++)
				System.out.println(list[i]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
