package com.strategypattern;

public class DragonSlayer {
	public interface DragonSlayingStrategy {
	    void execute();
	}
	
	/**
	 * 念魔咒策略
	 */
	public static class SpellStrategy implements DragonSlayingStrategy{
	 
	    @Override
	    public void execute() {
	        System.out.println("魔咒策略: 念魔咒把龙封印掉");
	    }
	}
	
	/**
	 * 火器策略
	 */
	public static class FireStrategy implements DragonSlayingStrategy {
	    @Override
	    public void execute() {
	        System.out.println("火器策略: 用火烧");
	    }
	}
	
	
	
	
	/**
     * 屠龙策略
     */
    private DragonSlayingStrategy strategy;
 
 
    /**
     * 如果是空参构造器, 那么赋上一个默认的策略
     */
    public DragonSlayer() {
        strategy = new DragonSlayingStrategy() {
            @Override
            public void execute() {
                System.out.println("默认策略: 拳打脚踢");
            }
        };
    }
 
    /**
     * 传入一个策略, 根据这个策略来进行实例化屠龙勇士
     */
    public DragonSlayer(DragonSlayingStrategy strategy) {
        this.strategy = strategy;
    }
 
    /**
     * 策略是可以随时变的, change一下就好了
     */
    public DragonSlayer changeStrategy(DragonSlayingStrategy strategy) {
        this.strategy = strategy;
        return this;
    }
 
    /**
     * 使用当前策略来执行屠龙
     */
    public void goToBattle() {
        this.strategy.execute();
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 有一个屠龙勇士
        DragonSlayer slayer = new DragonSlayer();
 
        System.out.println("\n幼龙出现啦");
 
        slayer.goToBattle();
 
        /*-************世界安静了片刻**************-*/
 
        System.out.println("\n冰龙出现啦!");
 
        //屠龙勇士发现可以用火克制他, 于是换了火器策略, 进行攻击
        slayer.changeStrategy(new FireStrategy()).goToBattle();
 
        /*-************世界安静了片刻**************-*/
 
        System.out.println("\n远古巨龙出现啦!");
 
        // 巨龙太强大了, 只能装备好念魔咒这个技能, 然后攻击
        slayer.changeStrategy(new SpellStrategy()).goToBattle();
 
        /*-************世界安静了片刻**************-*/
 
        System.out.println("\n魔龙出现啦");
 
        // 屠龙勇士用光了所有策略, 现场学会了一个新的技能, 还没来得及给这个技能起名字呢, 屠龙要紧, 快快快
        slayer.changeStrategy(new DragonSlayingStrategy() {
            @Override
            public void execute() {
                System.out.println("神秘技能: 顿悟出一套从天而降的掌法, 如来神掌!");
            }
        }).goToBattle();
 
        /*-************世界安静了片刻**************-*/
        System.out.println("\n神龙出现啦");
 
        // 屠龙勇士利用函数式编程发明了一种新的神级招式: 洗脑
        slayer.changeStrategy(()-> System.out.println("洗脑策略: 洗脑~~~~~~")).goToBattle();
	}

}
