package com.ppl.Lists;

import java.util.*;

/*“回调”一词的来历，这是由于quickSort()方法“往回调用”了Compare 中的方法。
从中亦可理解这种技术如何生成通用的、可重复利用（再生）的代码*/
public class SortVector extends Vector {
	private Compare compare; // To hold the callback

	public SortVector(Compare comp) {
		compare = comp;
	}

	public void sort() {
		quickSort(0, size() - 1);
	}

	private void quickSort(int left, int right) {
		if (right > left) {
			Object o1 = elementAt(right);
			int i = left - 1;
			int j = right;
			while (true) {
				while (compare.lessThan(elementAt(++i), o1))
					;
				while (j > 0)
					if (compare.lessThanOrEqual(elementAt(--j), o1))
						break; // out of while
				if (i >= j)
					break;
				swap(i, j);
			}
			swap(i, right);
			quickSort(left, i - 1);
			quickSort(i + 1, right);
		}
	}

	private void swap(int loc1, int loc2) {
		Object tmp = elementAt(loc1);
		setElementAt(elementAt(loc2), loc1);
		setElementAt(tmp, loc2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
