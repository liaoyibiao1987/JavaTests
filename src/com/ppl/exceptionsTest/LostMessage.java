package com.ppl.exceptionsTest;

/*A trivial exception
at LostMessage.dispose(LostMessage.java:21)
at LostMessage.main(LostMessage.java:29)


可以看到，这里不存在 VeryImportantException（非常重要的违例）的迹象，它只是简单地被 finally从句
中的HoHumException 代替了。
这是一项相当严重的缺陷，因为它意味着一个违例可能完全丢失。而且就象前例演示的那样，这种丢失显得
非常“自然”，很难被人查出蛛丝马迹。而与此相反，C++里如果第二个违例在第一个违例得到控制前产生，
就会被当作一个严重的编程错误处理。或许Java 以后的版本会纠正这个问题（上述结果是用Java 1.1 生成
的）。*/
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			lm.f();
		} finally {
			lm.dispose();
		}
	}

}
