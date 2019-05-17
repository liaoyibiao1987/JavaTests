package com.mementopattern;

import java.util.Random;

/*
 * 快照模式（备忘录设计模式）
 */
public class Memento {
	
	/**
	 * 游戏主人公
	 */
	public static class Gamer {
	    private static final Random random = new Random();
	 
	    /**
	     * 所持游戏金额
	     */
	    private int money;
	 
	    public Gamer(int money) {
	        this.money = money;
	    }
	 
	    public int getMoney() {                     // 获取当前所持金钱
	        return money;
	    }
	 
	    public void bet() {
	        int dice = random.nextInt(3) + 1;
	        if (dice == 1) {
	            money += 100;
	            System.out.println("所持金钱增加了。");
	        } else if (dice == 2) {
	            money -= random.nextInt(money - 1) + 1;
	            System.out.println("所持金钱减少了。");
	        } else {
	            System.out.println("什么都没有发生。");
	        }
	    }
	 
	    // 创建备忘录, 作为快照
	    public Memento createMemento() {
	        return new Memento(money);
	    }
	 
	    // 使用备忘录来进行恢复数据
	    public void restoreMemento(Memento memento) {
	        this.money = memento.getMoney();
	    }
	 
	    public String toString() {
	        return "[money = " + money + "]";
	    }
	}
	
	
	// 存档中的金额
    private int money;
 
    public int getMoney() {
        return money;
    }
 
    public Memento(int money) {
        this.money = money;
    }
    
    public static void main(String[] args) {
        // 最初的所持金钱数为100
        Gamer gamer = new Gamer(100);
 
        // 保存最初的状态
        Memento memento = gamer.createMemento();
 
        for (int i = 0; i < 10; i++) {
            // 显示当前是第几次循环
            System.out.println("==== " + i);
 
            // 显示主人公现在的金钱数
            System.out.println("当前状态:" + gamer);
 
            // 进行游戏
            gamer.bet();
 
            System.out.println("所持金钱为" + gamer.getMoney() + "元。");
 
            // 决定如何处理Memento,
            // 如果金币增加, 那么就继续
            // 如果金币减少了, 那么就从备忘录中获取
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("    （所持金钱增加了，因此保存游戏当前的状态）");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney()) {
                System.out.println("    （所持金钱减少了，因此将游戏恢复至以前的状态）");
                gamer.restoreMemento(memento);
                System.out.println("    （恢复之后的金钱为:" + gamer.getMoney() + "元）");
            }
 
            System.out.println("");
        }
    }
    
}
