package com.ppl.grammars;

public interface Selector {
	boolean end();

	Object current();

	void next();
}
