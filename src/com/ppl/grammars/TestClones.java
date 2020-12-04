package com.ppl.grammars;

public class TestClones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "a";
		String s2 = "a";//常量池中的值
		
		//JVM就已经为"a"在堆中创建了一个拘留字符串
		//(值得注意的是：如果源程序中还有一个"a"字符串常量，那么他们都对应了同一个堆中的拘留字符串)。
		//然后用这个拘留字符串的值来初始化堆中用new指令创建出来的新的String对象，
		//局部变量s实际上存储的是new出来的堆对象地址。
		String s3 = new String("a");
		String s4 = new String("a");
		System.out.println(s3.hashCode() + "====" + s1.hashCode());
		String s5 = String.valueOf("a");
		String s6 = String.valueOf("a");
		System.out.println(s1 == s2); // true 均是指向常量池中的"a",因此相等
		System.out.println(s1 == s3); // false 代表堆上的对象，与 s1 不等
		System.out.println(s3 == s4); // false 分别代表不同对象
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
