package com.ppl.javaIO;

import java.io.*;

/*若不是特别在意要实现 Externalizable接口，还有另一种方法可供选用。我们可以实现 Serializable接
口，并添加（注意是“添加”，而非“覆盖”或者“实现”）名为writeObject()和 readObject()的方法。
一旦对象被序列化或者重新装配，就会分别调用那两个方法。也就是说，只要提供了这两个方法，就会优先
使用它们，而不考虑默认的序列化机制。
这些方法必须含有下列准确的签名：
	private void
		writeObject(ObjectOutputStream stream)
		throws IOException;
	private void
		readObject(ObjectInputStream stream)
		throws IOException, ClassNotFoundException
从设计的角度出发，情况变得有些扑朔迷离。
首先，大家可能认为这些方法不属于基础类或者Serializable接口的一部分，它们应该在自己的接口中得到定义。
但请注意它们被定义成“private”，这意味着它们只能
由这个类的其他成员调用。然而，我们实际并不从这个类的其他成员中调用它们，而是由ObjectOutputStream 和ObjectInputStream的 writeObject()
及 readObject()方法来调用我们对象的writeObject()和readObject()方法（注意我在这里用了很大的抑制力来避免使用相同的方法名——因为怕混淆）。
大家可能奇怪 ObjectOutputStream 和ObjectInputStream如何有权访问我们的类的private方法——------------------------只能认为这是序列化机制玩的一个把戏。
在任何情况下，接口中的定义的任何东西都会自动具有public 属性，所以假若writeObject()和
readObject()必须为 private，那么它们不能成为接口（interface）的一部分。但由于我们准确地加上了签
名，所以最终的效果实际与实现一个接口是相同的。
看起来似乎我们调用ObjectOutputStream.writeObject()的时候，我们传递给它的Serializable对象似乎
会被检查是否实现了自己的writeObject()。若答案是肯定的是，便会跳过常规的序列化过程，并调用
writeObject()。readObject()也会遇到同样的情况。
还存在另一个问题。

在我们的writeObject()内部，可以调用defaultWriteObject()，从而决定采取默认的writeObject()行动。
类似地，在 readObject()内部，可以调用defaultReadObject()。下面这个简单的例子
演示了如何对一个Serializable 对象的存储与恢复进行控制：*/

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

	// 就算没有implements Externalizable 只要有两个方法签名，编译器就认为实现了Externalizable
	private void writeObject(ObjectOutputStream stream) throws IOException {
		// 先采取默认的writeObject()，然后再执行下面的对transient的赋值
		stream.defaultWriteObject();
		stream.writeObject(b);
	}

	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		b = (String) stream.readObject();
	}

	
	/*
	 * 在这个例子中，一个String 保持原始状态，其他设为transient（临时），以便证明非临时字段会被
	 * defaultWriteObject()方法自动保存，而 transient 字段必须在程序中明确保存和恢复。字段是在构建器内
	 * 部初始化的，而不是在定义的时候，这证明了它们不会在重新装配的时候被某些自动化机制初始化。 若准备通过默认机制写入对象的非 transient
	 * 部分，那么必须调用defaultWriteObject()，令其作为
	 * writeObject()中的第一个操作；并调用defaultReadObject()，令其作为 readObject()的第一个操作。这些
	 * 都是不常见的调用方法。举个例子来说，当我们为一个ObjectOutputStream 调用defaultWriteObject()的
	 * 时候，而且没有为其传递参数，就需要采取这种操作，使其知道对象的句柄以及如何写入所有非transient 的部分。这种做法非常不便。
	 * transient 对象的存储与恢复采用了我们更熟悉的代码。现在考虑一下会发生一些什么事情。在 main()中会 创建一个SerialCtl
	 * 对象，随后会序列化到一个ObjectOutputStream 里（注意这种情况下使用的是一个缓冲
	 * 区，而非文件——与ObjectOutputStream 完全一致）。正式的序列化操作是在下面这行代码里发生的：
	 * o.writeObject(sc); 其中，writeObject()方法必须核查sc，判断它是否有自己的
	 * writeObject()方法（不是检查它的接口——它
	 * 根本就没有，也不是检查类的类型，而是利用反射方法实际搜索方法）。若答案是肯定的，就使用那个方 法。类似的情况也会在
	 * readObject()上发生。或许这是解决问题唯一实际的方法，但确实显得有些古怪。
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
