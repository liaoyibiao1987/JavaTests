package com.keywords;


public class NewProperty extends BaseProperty {
	/*
	 * java中子类和父类有相同的成员变量 ，何种取值问题
	 * 
	 * 	1：子类，父类含有相同的成员变量，数值看引用型变量所属的类，即左边
		2：父类独有方法改变成员变量值，则改变的是父类中的数据
		3：子类重载父类方法，调用的是子类的方法，改变的是子类数据
		4：如果在多态，即Parent c = new Child(),子类重载父类方法，则c.方法( ) 调用的是子类的方法，改变的子类变量数据，c.变量 显示的是父类数据，还是未改变的。
	 */
	protected String name = "NewProperty";

	@Override
	public void BaseFunction() {
		//java中并不强制override必须添加 super， 但是android中SDK和IDE为了更好的编译和使用，会在某些方法中需要强制加上super，比如 super.onStart()
		//super.BaseFunction();		
		System.out.println("NewProperty BaseFunction.");
	};

	public static void main(String[] args) {
		NewProperty newProperty = new NewProperty();
		BaseProperty baseProperty = new NewProperty();
		
		System.out.println(newProperty.getName());
		System.out.println(newProperty.name);
		System.out.println(baseProperty.name);
		
		newProperty.BaseFunction();
	}
}
