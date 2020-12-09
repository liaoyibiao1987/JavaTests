package com.ppl.javaIO;

import java.io.*;

public class Redirecting {
	/*无论 System.setOut()还是System.setErr()都要求用一个 PrintStream作为参数使用，所以必须调用
	PrintStream构建器。所以大家可能会觉得奇怪，既然 Java 1.1 通过反对构建器而反对了整个
	PrintStream，为什么库的设计人员在添加这个反对的同时，依然为 System添加了新方法，且指明要求用
	PrintStream，而不是用 PrintWriter 呢？毕竟，后者是一个崭新和首选的替换措施呀？这真令人费解。*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/*BufferedInputStream in = new BufferedInputStream(new FileInputStream("src\\com\\ppl\\javaIO\\Redirecting.java"));*/
			
			BufferedInputStream in = new BufferedInputStream(new FileInputStream("1.txt"));
			// Produces deprecation message:
			/*PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));*/
			PrintStream out = new PrintStream(new FileOutputStream("test.out.txt"));
			System.setIn(in);
			System.setOut(out);
			System.setErr(out);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s;
			while ((s = br.readLine()) != null)
				System.out.println(s);
			out.close(); // Remember this!
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
