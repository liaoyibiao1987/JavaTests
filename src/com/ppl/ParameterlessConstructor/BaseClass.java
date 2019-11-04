package com.ppl.ParameterlessConstructor;

public class BaseClass {
	public String Name;
	
	private BaseClass() {
		Name = "BaseClass";
	}
	
	public BaseClass(String name){
		Name = name;
	}
}
