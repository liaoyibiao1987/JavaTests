package com.ppl.javaIO;

import java.io.*;
import java.util.*;

/*正如大家看到的那样，默认的序列化机制并不难操纵。然而，假若有特殊要求又该怎么办呢？我们可能有特
殊的安全问题，不希望对象的某一部分序列化；或者某一个子对象完全不必序列化，因为对象恢复以后，那
一部分需要重新创建。*/

class Blip1 implements Externalizable {
	public Blip1() {
		System.out.println("Blip1 Constructor");
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip1.writeExternal");
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip1.readExternal");
	}
}

// Blip1 的构建器是“公共的”（public），Blip2 的构建器则不然，这样便会在恢复时造成违例。
class Blip2 implements Externalizable {
	Blip2() {
		System.out.println("Blip2 Constructor");
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip2.writeExternal");
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip2.readExternal");
	}
}

/*
 * 恢复b1后，会调用 Blip1 默认构建器。这与恢复一个Serializable（可序列化）对象不同。在后者的情况
 * 下，对象完全以它保存下来的二进制位为基础恢复，不存在构建器调用。而对一个Externalizable 对象，所
 * 有普通的默认构建行为都会发生（包括在字段定义时的初始化），而且会调用readExternal()。必须注意这
 * 一事实——特别注意所有默认的构建行为都会进行——否则很难在自己的 Externalizable 对象中产生正确的 行为
 */
public class Serializable2Blip {
	public static void main(String[] args) {
		System.out.println("Constructing objects:");
		Blip1 b1 = new Blip1();
		Blip2 b2 = new Blip2();
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
			System.out.println("Saving objects:");
			o.writeObject(b1);
			o.writeObject(b2);
			o.close();
			// Now get them back:
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
			System.out.println("Recovering b1:");
			b1 = (Blip1) in.readObject();
			// OOPS! Throws an exception:
			// ! System.out.println("Recovering b2:");
			// ! b2 = (Blip2)in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
