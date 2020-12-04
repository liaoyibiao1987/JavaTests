package com.TestJava;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

public class GenericsTypes {
    /*
    按C#对泛型的理解，泛型实质就是类的模板。我们认为很容易知道类ArrayList<String>和ArrayList<Integer>应该是不同的类型。
    但是Java运行结果判断ArrayList<String>和ArrayList<Integer>是相同的类型。

    我们马上会有疑问，在运行状态，我们的泛型参数类型信息哪去了？我们的泛型怎么了?
    在运行状态，我们无法获取泛型的参数信息。Java的泛型不是真正的泛型，只是编译器的泛型，不是运行时的泛型。
    */

    /*
    C#中是在CLR中为T指定的类型，也在此时创建的类，static也在此时才被加载到了内存当中。
    在Java中T就单纯的是一个对象，而这个对象在编译的时候就需要指定其类型
    */

    /*
    C#泛型类在编译时，先生成中间代码IL，通用类型T只是一个占位符
    在实例化类时，根据用户指定的数据类型代替T并由即时编译器（JIT）生成本地代码
    这个本地代码中已经使用了实际的数据类型，等同于用实际类型写的类
    所以不同的封闭类的本地代码是不一样的

    对java虚拟机来说是没有泛型类的
    java编译器在编译泛型类是会用泛型类的左边第一个限定类去替换
    eg: ArrayList<T extend a & b>编译后ArrayList的所以T会被a 去替换
    但put数据是、编译器会检查put的数据是不是a类型的,但get数据时、他会返回a类型的数据.并添加类型转换代码（这样效率就低了）
    eg: ArrayList<News> arrayList=new ...; arrayList.get(0);
    编译器会返回 a类型的数据,然后把 数据拆箱转换成News数据
    总之java没有泛型类、在编译后都是基本的类型、并加类类型转换
    */
    public static void main(String[] args) {
        SClass x = TestGenerics.getNewOne(0);
        FClass x1 = TestGenerics.getNewOne(1);

        //如果在使用泛型时没有指明数据类型，那么就会擦除泛型类型,编译器会自动填入Object去转换
        Point p = new Point(); // 类型擦除
        p.setX(10);
        p.setY(20.8);
        int a = (Integer) p.getX(); // 向下转型
        double b = (Double) p.getY();

        Point<Integer, Double> p2 = new Point(); // 类型在运行时还是擦除的,在运行时都是object。不同的只是在编译阶段，编译器会检测是否合法而已
        p2.setX(12);
        p2.setY(12.09);
        int a2 = p2.getX();
        double b2 = p2.getY();

        /*List<String> list = new ArrayList();
        list.add(123);*/

        System.out.println("This point is：" + a + ", " + b);
    }

    public static class FClass {
        public FClass() {

        }
    }

    public static class SClass extends FClass {
        public SClass() {

        }
    }

    static class TestGenerics {
        public static <T extends FClass> T getNewOne(int type) {
            if (type == 0) {
                return (T) new FClass();
            } else if (type == 1) {
                return (T) new SClass();
            } else {
                return null;
            }
        }
    }


    static class Point<T1, T2> {
        T1 x;
        T2 y;

        public T1 getX() {
            return x;
        }

        public void setX(T1 x) {
            this.x = x;
        }

        public T2 getY() {
            return y;
        }

        public void setY(T2 y) {
            this.y = y;
        }
    }
}
