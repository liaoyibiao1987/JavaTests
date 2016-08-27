package com.ppl.exceptionsTest;

import java.io.*;


	/*����InputFile �Ĺ�����������һ��String���ִ���������������������򿪵��Ǹ��ļ������֡���һ��
	try���ڲ������ø��ļ���������һ�� FileReader����FileReader��˵������ת�Ʋ���������һ���ܹ�ʵ��
	��֮����̸����BufferedReader�������ûʲô�ô���ע��InputFile ��һ���ô�������ͬʱ�ϲ���������
	�ж���
	��FileReader ���������ɹ����ͻ����һ�� FileNotFoundException���ļ�δ�ҵ�Υ���������뵥��������
	��Υ���������������ǲ���ر��ļ���һ�������������Ϊ�ļ���δ�ɹ��򿪡������κβ���Ӿ䣨catch��
	������ر��ļ�����Ϊ�ļ����ڽ�����Щ����Ӿ�ʱ�򿪣���Ȼ���������������ܲ���һ��
	FileNotFoundExceptionΥ��������Ҫ��΢��һЩ���ɡ���ʱ�����ǿɽ���ͬ������ָ�������try ��
	�ڣ���close()����������һ�����Թ���Υ������ʹ������һ��catch �Ӿ�Ĵ�����ڣ���Υ��Ҳ����Բ�
	�񡪡���Java ��������˵���Ǹ� catch �Ӿ䲻������һ�Ի����Ŷ��ѡ�ִ���걾�ز�����Υ���ᱻ����
	�����������������Ǳ�Ҫ�ģ���Ϊ�����������ִ���Ѿ�ʧ�ܣ����ǲ�ϣ�����÷����������������ȷ����
	�Լ���Ч��
	����������У�û�в���ǰ���ı�־������finally�Ӿ���Ȼ���ǹر��ļ�����ȷ�ط�����Ϊ�������ÿ��
	������������ʱ��ر�������������ϣ���ļ���InputFile �����ڻ״̬ʱһֱ���ִ�״̬��������
	��������ǡ����
	getLine()�����᷵��һ���ִ������а������ļ�����һ�е����ݡ���������readLine()�����߿��ܲ���һ
	��Υ�������Ǹ�Υ���ᱻ����ʹ getLine()�����ٲ����κ�Υ������Υ����˵��һ���ر����������Ǿ�
	������һ����ȫ����һ��Υ�������ǽ��в��ֿ��ƣ���������ͬ����ͬ����Υ��������ֻ�Ǽ򵥵ش���
	�������ʵ���ʱ�򣬼򵥵ش��ݿɼ�������ǵı��빤����getLine()�������ɣ�
	String getLine() throws IOException {
	return in.readLine();
	}
	���ǵ�Ȼ��������������Ҫ�Կ��ܲ������κ� IOException���п��ơ�
	�û�ʹ�����InputFile ����󣬱������ cleanup()�������Ա��ͷ��� BufferedReader�Լ�������
	FileReaderռ�õ�ϵͳ��Դ�����ļ����������ע�͢ޡ�����InputFile ����ʹ����ϣ����ҵ�����Ҫ��֮
	���õ�ʱ�򣬷���Ӧ�����������ҿ�����������Ļ�������һ��finalize()�����ڣ�������� 4 ��ָ��
	���������������ܱ�֤ finalize()�����ȷ�ĵ��ã�����ȷ��������ã�Ҳ��֪����ʱ��ʼ���������� Java
	��һ��ȱ�ݡ������ڴ����֮�����������������Զ����У����Ա���֪��ͻ�����Ա������������������
	finalize()��֤�����������ȷ���С�*/

class InputFile {
	private BufferedReader in;

	InputFile(String fname) throws Exception {
		try {
			in = new BufferedReader(new FileReader(fname));
			// Other code that might throw exceptions
		} catch (FileNotFoundException e) {
			System.out.println("Could not open " + fname);
			// Wasn't open, so don't close it
			throw e;
		} catch (Exception e) {
			// All other exceptions must close it
			try {
				in.close();
			} catch (IOException e2) {
				System.out.println("in.close() unsuccessful");
			}
			throw e;
		} finally {
			// Don't close it here!!!
		}
	}

	String getLine() {
		String s;
		try {
			s = in.readLine();
		} catch (IOException e) {
			System.out.println("readLine() unsuccessful");
			s = "failed";
		}
		return s;
	}

	void cleanup() {
		try {
			in.close();
		} catch (IOException e2) {
			System.out.println("in.close() unsuccessful");
		}
	}
}

public class Cleanup {
	public static void main(String[] args) {
		try {
			InputFile in = new InputFile("c://UCLiveCore.dll");
			String s;
			int i = 1;
			while ((s = in.getLine()) != null)
				System.out.println("" + i++ + ": " + s);
			in.cleanup();
		} catch (Exception e) {
			System.out.println("Caught in main, e.printStackTrace()");
			e.printStackTrace();
		}

		try {
			InputFile in2 = new InputFile("oem8.log");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
