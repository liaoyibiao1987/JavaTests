package com.ppl.javaIO;

import java.io.*;

public class Redirecting {
	/*���� System.setOut()����System.setErr()��Ҫ����һ�� PrintStream��Ϊ����ʹ�ã����Ա������
	PrintStream�����������Դ�ҿ��ܻ������֣���Ȼ Java 1.1 ͨ�����Թ�����������������
	PrintStream��Ϊʲô��������Ա�����������Ե�ͬʱ����ȻΪ System������·�������ָ��Ҫ����
	PrintStream���������� PrintWriter �أ��Ͼ���������һ��ո�º���ѡ���滻��ʩѽ���������˷ѽ⡣*/
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
