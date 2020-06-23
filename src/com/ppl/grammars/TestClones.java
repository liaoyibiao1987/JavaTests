package com.ppl.grammars;

public class TestClones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "a";
		String s2 = "a";//�������е�ֵ
		
		//JVM���Ѿ�Ϊ"a"�ڶ��д�����һ�������ַ���
		//(ֵ��ע����ǣ����Դ�����л���һ��"a"�ַ�����������ô���Ƕ���Ӧ��ͬһ�����еľ����ַ���)��
		//Ȼ������������ַ�����ֵ����ʼ��������newָ����������µ�String����
		//�ֲ�����sʵ���ϴ洢����new�����ĶѶ����ַ��
		String s3 = new String("a");
		String s4 = new String("a");
		System.out.println(s3.hashCode() + "====" + s1.hashCode());
		String s5 = String.valueOf("a");
		String s6 = String.valueOf("a");
		System.out.println(s1 == s2); // true ����ָ�������е�"a",������
		System.out.println(s1 == s3); // false ������ϵĶ����� s1 ����
		System.out.println(s3 == s4); // false �ֱ����ͬ����
		System.out.println(s5 == s1); // true
		System.out.println(s5 == s6); // true

		TestSatic testSatic = new TestSatic(s1, 1);
		System.out.println(s1.hashCode());
		s1 = "AAAA";
		System.out.println(s1.hashCode());
		System.out.println(testSatic.getTelNumber().hashCode());
		System.out.println(testSatic.getTelNumber() == s1); // true
	}

	static class TestSatic {
		private String telNumber;
		private int decodeChannel;

		public TestSatic(String telNum, int channel) {
			telNumber = telNum;
			decodeChannel = channel;
		}

		public String getTelNumber() {
			return telNumber;
		}

		public void setTelNumber(String telNumber) {
			this.telNumber = telNumber;
		}

		public int getDecodeChannel() {
			return decodeChannel;
		}

		public void setDecodeChannel(int decodeChannel) {
			this.decodeChannel = decodeChannel;
		}
	}

}
