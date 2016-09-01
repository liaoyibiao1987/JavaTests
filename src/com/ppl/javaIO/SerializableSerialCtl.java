package com.ppl.javaIO;

import java.io.*;

/*�������ر�����Ҫʵ�� Externalizable�ӿڣ�������һ�ַ����ɹ�ѡ�á����ǿ���ʵ�� Serializable��
�ڣ�����ӣ�ע���ǡ���ӡ������ǡ����ǡ����ߡ�ʵ�֡�����ΪwriteObject()�� readObject()�ķ�����
һ���������л���������װ�䣬�ͻ�ֱ����������������Ҳ����˵��ֻҪ�ṩ���������������ͻ�����
ʹ�����ǣ���������Ĭ�ϵ����л����ơ�
��Щ�������뺬������׼ȷ��ǩ����
	private void
		writeObject(ObjectOutputStream stream)
		throws IOException;
	private void
		readObject(ObjectInputStream stream)
		throws IOException, ClassNotFoundException
����ƵĽǶȳ�������������Щ��˷���롣
���ȣ���ҿ�����Ϊ��Щ���������ڻ��������Serializable�ӿڵ�һ���֣�����Ӧ�����Լ��Ľӿ��еõ����塣
����ע�����Ǳ�����ɡ�private��������ζ������ֻ��
��������������Ա���á�Ȼ��������ʵ�ʲ�����������������Ա�е������ǣ�������ObjectOutputStream ��ObjectInputStream�� writeObject()
�� readObject()�������������Ƕ����writeObject()��readObject()������ע�������������˺ܴ��������������ʹ����ͬ�ķ�����������Ϊ�»�������
��ҿ������ ObjectOutputStream ��ObjectInputStream�����Ȩ�������ǵ����private��������------------------------ֻ����Ϊ�������л��������һ����Ϸ��
���κ�����£��ӿ��еĶ�����κζ��������Զ�����public ���ԣ����Լ���writeObject()��
readObject()����Ϊ private����ô���ǲ��ܳ�Ϊ�ӿڣ�interface����һ���֡�����������׼ȷ�ؼ�����ǩ
�����������յ�Ч��ʵ����ʵ��һ���ӿ�����ͬ�ġ�
�������ƺ����ǵ���ObjectOutputStream.writeObject()��ʱ�����Ǵ��ݸ�����Serializable�����ƺ�
�ᱻ����Ƿ�ʵ�����Լ���writeObject()�������ǿ϶����ǣ����������������л����̣�������
writeObject()��readObject()Ҳ������ͬ���������
��������һ�����⡣

�����ǵ�writeObject()�ڲ������Ե���defaultWriteObject()���Ӷ�������ȡĬ�ϵ�writeObject()�ж���
���Ƶأ��� readObject()�ڲ������Ե���defaultReadObject()����������򵥵�����
��ʾ����ζ�һ��Serializable ����Ĵ洢��ָ����п��ƣ�*/

public class SerializableSerialCtl implements Serializable {
	String a;
	transient String b;

	public SerializableSerialCtl(String aa, String bb) {
		a = "Not Transient: " + aa;
		b = "Transient: " + bb;
	}

	public String toString() {
		return a + "\n" + b;
	}

	// ����û��implements Externalizable ֻҪ����������ǩ��������������Ϊʵ����Externalizable
	private void writeObject(ObjectOutputStream stream) throws IOException {
		// �Ȳ�ȡĬ�ϵ�writeObject()��Ȼ����ִ������Ķ�transient�ĸ�ֵ
		stream.defaultWriteObject();
		stream.writeObject(b);
	}

	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		b = (String) stream.readObject();
	}

	
	/*
	 * ����������У�һ��String ����ԭʼ״̬��������Ϊtransient����ʱ�����Ա�֤������ʱ�ֶλᱻ
	 * defaultWriteObject()�����Զ����棬�� transient �ֶα����ڳ�������ȷ����ͻָ����ֶ����ڹ�������
	 * ����ʼ���ģ��������ڶ����ʱ����֤�������ǲ���������װ���ʱ��ĳЩ�Զ������Ƴ�ʼ���� ��׼��ͨ��Ĭ�ϻ���д�����ķ� transient
	 * ���֣���ô�������defaultWriteObject()��������Ϊ
	 * writeObject()�еĵ�һ��������������defaultReadObject()��������Ϊ readObject()�ĵ�һ����������Щ
	 * ���ǲ������ĵ��÷������ٸ�������˵��������Ϊһ��ObjectOutputStream ����defaultWriteObject()��
	 * ʱ�򣬶���û��Ϊ�䴫�ݲ���������Ҫ��ȡ���ֲ�����ʹ��֪������ľ���Լ����д�����з�transient �Ĳ��֡����������ǳ����㡣
	 * transient ����Ĵ洢��ָ����������Ǹ���Ϥ�Ĵ��롣���ڿ���һ�»ᷢ��һЩʲô���顣�� main()�л� ����һ��SerialCtl
	 * �����������л���һ��ObjectOutputStream �ע�����������ʹ�õ���һ������
	 * ���������ļ�������ObjectOutputStream ��ȫһ�£�����ʽ�����л����������������д����﷢���ģ�
	 * o.writeObject(sc); ���У�writeObject()��������˲�sc���ж����Ƿ����Լ���
	 * writeObject()���������Ǽ�����Ľӿڡ�����
	 * ������û�У�Ҳ���Ǽ��������ͣ��������÷��䷽��ʵ�������������������ǿ϶��ģ���ʹ���Ǹ��� �������Ƶ����Ҳ����
	 * readObject()�Ϸ������������ǽ������Ψһʵ�ʵķ�������ȷʵ�Ե���Щ�Ź֡�
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializableSerialCtl sc = new SerializableSerialCtl("Test1", "Test2");
		System.out.println("Before:\n" + sc);
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		try {
			ObjectOutputStream o = new ObjectOutputStream(buf);
			o.writeObject(sc);
			// Now get it back:
			ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
			SerializableSerialCtl sc2 = (SerializableSerialCtl) in.readObject();
			System.out.println("After:\n" + sc2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
