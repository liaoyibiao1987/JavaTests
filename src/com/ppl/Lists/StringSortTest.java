package com.ppl.Lists;

import java.util.Enumeration;

/*�ڲ����ǡ���̬����Static���ģ���Ϊ����������һ���ⲿ�༴�ɹ�����
��ҿ��Կ�����һ�����úÿ�ܣ��Ϳ��Էǳ�������ظ�ʹ����������һ����ơ���ֻ��򵥵�дһ���࣬
������Ҫ�����仯���Ķ�����װ��ȥ��Ȼ��һ�����󴫸�SortVector ���ɡ�
�Ƚ�ʱ���ִ�ǿ��ΪСд��ʽ�����Դ�дA ��������Сд a���Աߣ��������ƶ�һ����ȫ��ͬ�ĵط�

����Ҳ��ʾ�����ַ�����һ�����㣬��Ϊ�������Դ��밴�ճ���˳������ͬһ����ĸ�Ĵ�д��Сд��
ʽ��A a b B c C d D������ͨ������һ�������⣬��Ϊ��������Ķ��Ǹ������ִ�����������Ч��������¶
������Java 1.2 �ļ����ṩ�������ܣ��ѽ����������⣩��
�̳У�extends����������ڴ���һ�������͵�Vector����Ҳ����˵��SortVector ����һ��Vector��������
һЩ���ӵĹ��ܡ��̳�������ɷ��Ӻܴ�����ã����˴��������⡣��ʹһЩ����������final ���ԣ�����
��7 �½����������Բ��ܸ������ǡ�����봴��һ���ź���� Vector������ֻ���պ����� String���󣬾�
�������鷳����ΪaddElement()��elementAt()������ final���ԣ��������Ƕ������Ǳ��븲�ǵķ�������
����޷�ʵ��ֻ�ܽ��պͲ���String ����
������һ���棬�뿼�ǲ��á��ϳɡ���������һ����������һ��������ڲ�����ʱ�����Ǹ�д������������
�����Ŀ�ģ�������������򵥵�ʹ��һ��SortVector������������£�����ʵ��Compare�ӿڵ��ڲ����
���ԡ��������ش�����*/


public class StringSortTest {
	static class StringCompare implements Compare {
		
		//��ΪaddElement()��elementAt()������ final���ԣ��������Ƕ������Ǳ��븲�ǵķ�����������޷�ʵ��ֻ�ܽ��պͲ���String ����
		public boolean lessThan(Object l, Object r) {
			return ((String) l).toLowerCase().compareTo(((String) r).toLowerCase()) < 0;
		}

		public boolean lessThanOrEqual(Object l, Object r) {
			return ((String) l).toLowerCase().compareTo(((String) r).toLowerCase()) <= 0;
		}
	}

	public static void main(String[] args) {
		SortVector sv = new SortVector(new StringCompare());
		sv.addElement("d");
		sv.addElement("A");
		sv.addElement("C");
		sv.addElement("c");
		sv.addElement("b");
		sv.addElement("B");
		sv.addElement("D");
		sv.addElement("a");
		sv.sort();
		Enumeration e = sv.elements();
		while (e.hasMoreElements())
			System.out.println(e.nextElement());
	}
}
