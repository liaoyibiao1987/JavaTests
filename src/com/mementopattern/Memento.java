package com.mementopattern;

import java.util.Random;

/*
 * ����ģʽ������¼���ģʽ��
 */
public class Memento {
	
	/**
	 * ��Ϸ���˹�
	 */
	public static class Gamer {
	    private static final Random random = new Random();
	 
	    /**
	     * ������Ϸ���
	     */
	    private int money;
	 
	    public Gamer(int money) {
	        this.money = money;
	    }
	 
	    public int getMoney() {                     // ��ȡ��ǰ���ֽ�Ǯ
	        return money;
	    }
	 
	    public void bet() {
	        int dice = random.nextInt(3) + 1;
	        if (dice == 1) {
	            money += 100;
	            System.out.println("���ֽ�Ǯ�����ˡ�");
	        } else if (dice == 2) {
	            money -= random.nextInt(money - 1) + 1;
	            System.out.println("���ֽ�Ǯ�����ˡ�");
	        } else {
	            System.out.println("ʲô��û�з�����");
	        }
	    }
	 
	    // ��������¼, ��Ϊ����
	    public Memento createMemento() {
	        return new Memento(money);
	    }
	 
	    // ʹ�ñ���¼�����лָ�����
	    public void restoreMemento(Memento memento) {
	        this.money = memento.getMoney();
	    }
	 
	    public String toString() {
	        return "[money = " + money + "]";
	    }
	}
	
	
	// �浵�еĽ��
    private int money;
 
    public int getMoney() {
        return money;
    }
 
    public Memento(int money) {
        this.money = money;
    }
    
    public static void main(String[] args) {
        // ��������ֽ�Ǯ��Ϊ100
        Gamer gamer = new Gamer(100);
 
        // ���������״̬
        Memento memento = gamer.createMemento();
 
        for (int i = 0; i < 10; i++) {
            // ��ʾ��ǰ�ǵڼ���ѭ��
            System.out.println("==== " + i);
 
            // ��ʾ���˹����ڵĽ�Ǯ��
            System.out.println("��ǰ״̬:" + gamer);
 
            // ������Ϸ
            gamer.bet();
 
            System.out.println("���ֽ�ǮΪ" + gamer.getMoney() + "Ԫ��");
 
            // ������δ���Memento,
            // ����������, ��ô�ͼ���
            // �����Ҽ�����, ��ô�ʹӱ���¼�л�ȡ
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("    �����ֽ�Ǯ�����ˣ���˱�����Ϸ��ǰ��״̬��");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney()) {
                System.out.println("    �����ֽ�Ǯ�����ˣ���˽���Ϸ�ָ�����ǰ��״̬��");
                gamer.restoreMemento(memento);
                System.out.println("    ���ָ�֮��Ľ�ǮΪ:" + gamer.getMoney() + "Ԫ��");
            }
 
            System.out.println("");
        }
    }
    
}
