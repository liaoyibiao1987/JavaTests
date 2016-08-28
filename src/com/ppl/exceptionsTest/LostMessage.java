package com.ppl.exceptionsTest;

/*A trivial exception
at LostMessage.dispose(LostMessage.java:21)
at LostMessage.main(LostMessage.java:29)


���Կ��������ﲻ���� VeryImportantException���ǳ���Ҫ��Υ�����ļ�����ֻ�Ǽ򵥵ر� finally�Ӿ�
�е�HoHumException �����ˡ�
����һ���൱���ص�ȱ�ݣ���Ϊ����ζ��һ��Υ��������ȫ��ʧ�����Ҿ���ǰ����ʾ�����������ֶ�ʧ�Ե�
�ǳ�����Ȼ�������ѱ��˲����˿����������෴��C++������ڶ���Υ���ڵ�һ��Υ���õ�����ǰ������
�ͻᱻ����һ�����صı�̴���������Java �Ժ�İ汾�����������⣨�����������Java 1.1 ����
�ģ���*/
public class LostMessage {
	class VeryImportantException extends Exception {
		public String toString() {
			return "A very important exception!";
		}
	}

	class HoHumException extends Exception {
		public String toString() {
			return "A trivial exception";
		}
	}

	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	void dispose() throws HoHumException {
		throw new HoHumException();
	}

	

	public static void main(String[] args) throws Exception {
		LostMessage lm = new LostMessage();
		try {
			lm.f();
		} catch (VeryImportantException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		try {
			lm.f();
		} finally {
			lm.dispose();
		}
	}

}
