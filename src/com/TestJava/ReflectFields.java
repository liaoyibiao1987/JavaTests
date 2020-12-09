package com.TestJava;

import java.lang.reflect.Field;



public class ReflectFields {

	public static String getAllFieldValue(Object object) {
		try {
			StringBuilder sb = new StringBuilder();
			Class clazz = object.getClass();
			Field[] fields = object.getClass().getDeclaredFields();// �������
			for (Field field : fields) {
				Object value = getValueFormObject(object, field.getName());
				sb.append(field.getName() + " : " + value + "; ");
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static Object getValueFormObject(Object object, String fieldName) {
		if (object == null) {
			// LOG.error("the fields is wrong,object is null,fieldName is
			// "+fieldName);
			System.out.println("the fields is wrong,object is null,fieldName is " + fieldName);
			return null;
		}
		if (fieldName == null || fieldName == "") {
			// LOG.error("the fields is wrong,object is null,object is
			// "+object.toString());
			System.out.println("the fields is wrong,object is null,fieldName is " + fieldName);
			return null;
		}
		Field field;
		try {
			field = object.getClass().getDeclaredField(fieldName);
			if (field != null) {
				field.setAccessible(true);
				return field.get(object);
			}
		} catch (NoSuchFieldException | IllegalAccessException e) {
			// LOG.error("Get Value Form Object Wrong");
			System.out.println("Get Value Form Object Wrong");
		}

		return null;
	}

	public static class Person {
		private String Name;
		public int Age;

		public Person(String name, int aget) {
			Name = name;
			Age = aget;
		}
	}
	
	

	public static void test2() {
		Object person = new Person("AAA", 23);
		String logs = getAllFieldValue(person);
		System.err.println("Person: " + logs);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test2();
	}
}
