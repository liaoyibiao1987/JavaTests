package com.ppl.javaIO;

import java.io.*;
import java.util.*;

abstract class Shape implements Serializable {
	public static final int RED = 1, BLUE = 2, GREEN = 3;
	private int xPos, yPos, dimension;
	private static Random r = new Random();
	private static int counter = 0;

	abstract public void setColor(int newColor);

	abstract public int getColor();

	public Shape(int xVal, int yVal, int dim) {
		xPos = xVal;
		yPos = yVal;
		dimension = dim;
	}

	public String toString() {
		return getClass().toString() + " color[" + getColor() + "] xPos[" + xPos + "] yPos[" + yPos + "] dim["
				+ dimension + "]\n";
	}

	public static Shape randomFactory() {
		int xVal = r.nextInt() % 100;
		int yVal = r.nextInt() % 100;
		int dim = r.nextInt() % 100;
		switch (counter++ % 3) {
		default:
		case 0:
			return new Circle(xVal, yVal, dim);
		case 1:
			return new Square(xVal, yVal, dim);
		case 2:
			return new Line(xVal, yVal, dim);
		}
	}
}

class Circle extends Shape {
	private static int color = RED;

	public Circle(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
	}

	public void setColor(int newColor) {
		color = newColor;
	}

	public int getColor() {
		return color;
	}
}

class Square extends Shape {
	private static int color;

	public Square(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
		color = RED;
	}

	public void setColor(int newColor) {
		color = newColor;
	}

	public int getColor() {
		return color;
	}
}

class Line extends Shape {
	private static int color = RED;
	
	//serializeStaticState ������Ծ�̬�ֶγ�ʼ��������
	public static void serializeStaticState(ObjectOutputStream os) throws IOException {
		os.writeInt(color);
	}
	//serializeStaticState ������Ծ�̬�ֶγ�ʼ��������
	public static void deserializeStaticState(ObjectInputStream os) throws IOException {
		color = os.readInt();
	}

	public Line(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
	}

	public void setColor(int newColor) {
		color = newColor;
	}

	public int getColor() {
		return color;
	}
}
/*
 * Shape��������״���ࡰʵ���˿����л�����implements Serializable�������Դ� Shape�̳е��κζ���Ҳ
 * �����Զ��������л�����ÿ��Shape �����������ݣ�����ÿ��������Shape �඼������һ������� static �� �Σ����ھ���������Щ���͵�Shape
 * ����ɫ���罫һ�� static�ֶ���������࣬���ֻ�����һ���ֶΣ��� Ϊstatic
 * �ֶ�δ���������и��ƣ����ɶԻ������еķ������и��Ǵ����Ա�Ϊ��ͬ������������ɫ��static
 * �������ᶯ̬�󶨣�������Щ������ͨ�ķ�������ÿ�ε���randomFactory()����ʱ�������ᴴ�� һ����ͬ�� Shape��Shape ֵ�������ֵ����
 * Circle��Բ���� Square�����Σ����ڶ�Shape ��ֱ����չ��Ψһ�Ĳ����Circle �ڶ���ʱ���ʼ����ɫ�� ��Square
 * �ڹ������г�ʼ����Line��ֱ�ߣ������⽫�����Ժ����ۡ� ��main()�У�һ��Vector ��������Class
 * ���󣬶���һ������������״�������ṩ��Ӧ�������в������� �ᴴ��shapeTypes Vector�������Class ����Ȼ�󴴽�shapes
 * Vector�������Shape ���󡣽��������� ��static color ֵ�������GREEN���������ж����������л����ļ�
 * CADState.out�� ���ṩ��һ�������в���������CADState.out���������Ǹ��ļ����������ָ������״̬������������
 * ����£����������Shape ��Vector �����ӡ������
 */


/*
 * >java CADState [
 * class Circle color[3] xPos[-51] yPos[-99] dim[38] , 
 * class Square color[3] xPos[2] yPos[61] dim[-46] , 
 * class Line color[3] xPos[51] yPos[73] dim[64] ,
 * class Circle color[3] xPos[-70] yPos[1] dim[16] ,
 * class Square color[3] xPos[3] yPos[94] dim[-36] , 
 * class Line color[3] xPos[-84] yPos[-21] dim[-35] , 
 * class Circle color[3] xPos[-75] yPos[-43] dim[22] ,
 * class Square color[3] xPos[81] yPos[30] dim[-45] , 
 * class Line color[3] xPos[-29] yPos[92] dim[17] , 
 * class Circle color[3] xPos[17] yPos[90] dim[-76]
 * 
 * ] >java CADState CADState.out [
 *   class Circle color[1] xPos[-51] yPos[-99] dim[38] 
 * , class Square color[0] xPos[2] yPos[61] dim[-46] 
 * , class Line color[3] xPos[51] yPos[73] dim[64] 
 * , class Circle color[1] xPos[-70] yPos[1] dim[16] 
 * , class Square color[0] xPos[3] yPos[94] dim[-36] 
 * , class Line color[3] xPos[-84] yPos[-21] dim[-35] 
 * , class Circle color[1] xPos[-75] yPos[-43] dim[22] 
 * , class Square color[0] xPos[81] yPos[30] dim[-45] 
 * , class Line color[3] xPos[-29] yPos[92] dim[17] 
 * , class Circle color[1] xPos[17] yPos[90] dim[-76] ]
 */


/*
 * ���п��Կ�����xPos��yPos �Լ�dim��ֵ���ѳɹ�����ͻָ����������ڻ�ȡ static��Ϣʱȴ��������
 * �⡣���С�3�����ѽ��룬��û�������س�����Circle ��һ�� 1ֵ������Ϊ RED������Square ��һ�� 0ֵ
 * ����ס���������ڹ��������ʼ���ģ�������ȥ�ƺ�static ����û�еõ���ʼ����ʵ��������ˡ��������� Class
 * �ǡ��������л��ġ�����ȴ���ܰ�����ϣ���Ĺ��������Լ��������л�staticֵ���������Զ��֡� ������Line �е�
 * serializeStaticState()��deserializeStaticState()����static ��������;�����Կ�
 * ��������������������Ϊ�洢�ͻָ����̵�һ������ȷ���õģ�ע��д�����л��ļ��ʹ��ж��ص�˳���� �ı䣩������Ϊ��ʹCADState.java
 * ��ȷ������������������������ַ���֮һ��
 *  (1) Ϊ������״���һ��serializeStaticState()�� deserializeStaticState()�� 
 *  (2) ɾ��Vector shapeTypes�Լ���֮�йص����д��� 
 *  (3) �ڼ�����״����Ӷ������л��ͳ������л���̬�����ĵ��� Ҫע�����һ�������ǰ�ȫ����Ϊ���л�����Ҳ�Ὣprivate ���ݱ���������
 *  ������Ҫ���ܵ��ֶΣ�Ӧ���� ��ǳ�transient��������֮�󣬱������һ�ְ�ȫ����Ϣ���淽��������һ����һ����Ҫ�ָ����Ϳ���������Щprivate ������
 */

public class SerializableCADState {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Vector shapeTypes, shapes;
		if (args.length == 0) {
			shapeTypes = new Vector();
			shapes = new Vector();
			// Add handles to the class objects:
			shapeTypes.addElement(Circle.class);
			shapeTypes.addElement(Square.class);
			shapeTypes.addElement(Line.class);
			// Make some shapes:
			for (int i = 0; i < 10; i++)
				shapes.addElement(Shape.randomFactory());
			// Set all the static colors to GREEN:
			for (int i = 0; i < 10; i++)
				((Shape) shapes.elementAt(i)).setColor(Shape.GREEN);
			// Save the state vector:
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
			out.writeObject(shapeTypes);
			Line.serializeStaticState(out);
			out.writeObject(shapes);
		} else { // There's a command-line argument
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
			// Read in the same order they were written:
			shapeTypes = (Vector) in.readObject();
			Line.deserializeStaticState(in);
			shapes = (Vector) in.readObject();
		}
		// Display the shapes:
		System.out.println(shapes);
	}

}
