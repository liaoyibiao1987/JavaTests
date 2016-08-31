package com.ppl.javaIO;

import java.io.*;
import java.util.*;

class Blip3 implements Externalizable {
	int i;
	String s; // No initialization

	public Blip3() {
		System.out.println("Blip3 Constructor");
		// s, i not initialized
	}

	public Blip3(String x, int a) {
		System.out.println("Blip3(String x, int a)");
		s = x;
		i = a;
		// s & i initialized only in non-default
		// constructor.
	}

	public String toString() {
		return s + i;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip3.writeExternal");
		// You must do this:
		out.writeObject(s);
		out.writeInt(i);
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip3.readExternal");
		// You must do this:
		s = (String) in.readObject();
		/* 如果不执行，则i再被read的时候就变成0了 */
		//i = in.readInt();
	}

}

/*
 * 字段 s和 i 只在第二个构建器中初始化，不关默认构建器的事。这意味着假如不在readExternal中初 始化s
 * 和i，它们就会成为null（因为在对象创建的第一步中已将对象的存储空间清除为 1）。若注释掉跟 随于“You must do
 * this”后面的两行代码，并运行程序，就会发现当对象恢复以后，s 是null，而i 是零。 若从一个Externalizable
 * 对象继承，通常需要调用writeExternal()和 readExternal()的基础类版本，以便 正确地保存和恢复基础类组件。
 */
public class Serializable2Blip3 {
	public static void main(String[] args) {
		System.out.println("Constructing objects:");
		Blip3 b3 = new Blip3("A String ", 47);
		System.out.println(b3.toString());
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
			System.out.println("Saving object:");
			o.writeObject(b3);
			o.close();
			// Now get it back:
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
			System.out.println("Recovering b3:");
			b3 = (Blip3) in.readObject();
			System.out.println(b3.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
