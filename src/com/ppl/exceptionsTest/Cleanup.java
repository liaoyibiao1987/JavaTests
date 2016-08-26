package com.ppl.exceptionsTest;

import java.io.*;


	/*用于InputFile 的构建器采用了一个String（字串）参数，它代表我们想打开的那个文件的名字。在一个
	try块内部，它用该文件名创建了一个 FileReader。对FileReader来说，除非转移并用它创建一个能够实际
	与之“交谈”的BufferedReader，否则便没什么用处。注意InputFile 的一个好处就是它同时合并了这两种
	行动。
	若FileReader 构建器不成功，就会产生一个 FileNotFoundException（文件未找到违例）。必须单独捕获这
	个违例——这属于我们不想关闭文件的一种特殊情况，因为文件尚未成功打开。其他任何捕获从句（catch）
	都必须关闭文件，因为文件已在进入那些捕获从句时打开（当然，如果多个方法都能产生一个
	FileNotFoundException违例，就需要稍微用一些技巧。此时，我们可将不同的情况分隔到数个try 块
	内）。close()方法会掷出一个尝试过的违例。即使它在另一个catch 从句的代码块内，该违例也会得以捕
	获——对Java 编译器来说，那个 catch 从句不过是另一对花括号而已。执行完本地操作后，违例会被重新
	“掷”出。这样做是必要的，因为这个构建器的执行已经失败，我们不希望调用方法来假设对象已正确创建
	以及有效。
	在这个例子中，没有采用前述的标志技术，finally从句显然不是关闭文件的正确地方，因为这可能在每次
	构建器结束的时候关闭它。由于我们希望文件在InputFile 对象处于活动状态时一直保持打开状态，所以这
	样做并不恰当。
	getLine()方法会返回一个字串，其中包含了文件中下一行的内容。它调用了readLine()，后者可能产生一
	个违例，但那个违例会被捕获，使 getLine()不会再产生任何违例。对违例来说，一项特别的设计问题是决
	定在这一级完全控制一个违例，还是进行部分控制，并传递相同（或不同）的违例，或者只是简单地传递
	它。在适当的时候，简单地传递可极大简化我们的编码工作。getLine()方法会变成：
	String getLine() throws IOException {
	return in.readLine();
	}
	但是当然，调用者现在需要对可能产生的任何 IOException进行控制。
	用户使用完毕InputFile 对象后，必须调用 cleanup()方法，以便释放由 BufferedReader以及／或者
	FileReader占用的系统资源（如文件句柄）——注释⑥。除非InputFile 对象使用完毕，而且到了需要弃之
	不用的时候，否则不应进行清除。大家可能想把这样的机制置入一个finalize()方法内，但正如第 4 章指出
	的那样，并非总能保证 finalize()获得正确的调用（即便确定它会调用，也不知道何时开始）。这属于 Java
	的一项缺陷——除内存清除之外的所有清除都不会自动进行，所以必须知会客户程序员，告诉他们有责任用
	finalize()保证清除工作的正确进行。*/

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
