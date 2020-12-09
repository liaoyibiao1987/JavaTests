package com.ppl.javaIO;

import java.io.*;

class Data implements Serializable {
	private int i;

	Data(int x) {
		i = x;
	}

	public String toString() {
		return Integer.toString(i);
	}
}
/*
 * 建立了许多链接对象的一个“Worm”（蠕虫），每个对象都与Worm 中的下一段链 接，同时又与属于不同类（Data）的对象句柄数组链接
 * 更有趣的是，Worm 内的Data 对象数组是用随机数字初始化的（这样便不用怀疑编译器保留了某种原始信 息）。每个 Worm 段都用一个 Char
 * 标记。这个Char 是在重复生成链接的 Worm 列表时自动产生的。创建一个 Worm
 * 时，需告诉构建器希望它有多长。为产生下一个句柄（next），它总是用减去 1 的长度来调用Worm 构建器。最后一个next
 * 句柄则保持为null（空），表示已抵达 Worm 的尾部。 上面的所有操作都是为了加深事情的复杂程度，加大对象序列化的难度。然而，真正的序列化过程却是非常
 * 简单的。一旦从另外某个流里创建了ObjectOutputStream，writeObject()就会序列化对象。注意也可以为 一个String调用
 * writeObject()。亦可使用与DataOutputStream 相同的方法写入所有基本数据类型（它们 有相同的接口）。
 * 有两个单独的try块看起来是类似的。第一个读写的是文件，而另一个读写的是一个 ByteArray（字节数 组）。可利用对任何DataInputStream
 * 或者DataOutputStream的序列化来读写特定的对象；正如在关于连网 的那一章会讲到的那样，这些对象甚至包括网络。
 */

/*
 * 可以看出，装配回原状的对象确实包含了原来那个对象里包含的所有链接。
 * 注意在对一个Serializable（可序列化）对象进行重新装配的过程中，
 * 
 * 不会调用任何构建器（甚至默认构建器）。
 * 
 * 整个对象都是通过从InputStream中取得数据恢复的。 作为Java 1.1特性的一种，我们注意到对象的序列化并不属于新的 Reader和
 * Writer层次结构的一部分，而 是沿用老式的InputStream 和OutputStream 结构。所以在一些特殊的场合下，不得不混合使用两种类型的层
 * 次结构。
 */

public class SerializableWorm implements Serializable {
	private static int r() {
		return (int) (Math.random() * 10);
	}

	private Data[] d = { new Data(r()), new Data(r()), new Data(r()) };
	private SerializableWorm next;
	private char c;

	// Value of i == number of segments
	SerializableWorm(int i, char x) {
		System.out.println(" Worm constructor: " + i);
		c = x;
		if (--i > 0)
			next = new SerializableWorm(i, (char) (x + 1));
	}

	SerializableWorm() {
		System.out.println("Default constructor");
	}

	public String toString() {
		String s = ":" + c + "(";
		for (int i = 0; i < d.length; i++)
			s += d[i].toString();
		s += ")";
		if (next != null)
			s += next.toString();
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializableWorm w = new SerializableWorm(6, 'a');
		System.out.println("w = " + w);
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.txt"));
			out.writeObject("Worm storage");
			out.writeObject(w);
			out.close(); // Also flushes output
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.txt"));
			String s = (String) in.readObject();
			SerializableWorm w2 = (SerializableWorm) in.readObject();
			System.out.println(s + ", w2 = " + w2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bout);
			out.writeObject("Worm storage");
			out.writeObject(w);
			out.flush();
			ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
			String s = (String) in.readObject();
			SerializableWorm w3 = (SerializableWorm) in.readObject();
			System.out.println(s + ", w3 = " + w3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
