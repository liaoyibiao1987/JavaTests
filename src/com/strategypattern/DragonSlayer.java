package com.strategypattern;

public class DragonSlayer {
	public interface DragonSlayingStrategy {
	    void execute();
	}
	
	/**
	 * ��ħ�����
	 */
	public static class SpellStrategy implements DragonSlayingStrategy{
	 
	    @Override
	    public void execute() {
	        System.out.println("ħ�����: ��ħ�������ӡ��");
	    }
	}
	
	/**
	 * ��������
	 */
	public static class FireStrategy implements DragonSlayingStrategy {
	    @Override
	    public void execute() {
	        System.out.println("��������: �û���");
	    }
	}
	
	
	
	
	/**
     * ��������
     */
    private DragonSlayingStrategy strategy;
 
 
    /**
     * ����ǿղι�����, ��ô����һ��Ĭ�ϵĲ���
     */
    public DragonSlayer() {
        strategy = new DragonSlayingStrategy() {
            @Override
            public void execute() {
                System.out.println("Ĭ�ϲ���: ȭ�����");
            }
        };
    }
 
    /**
     * ����һ������, �����������������ʵ����������ʿ
     */
    public DragonSlayer(DragonSlayingStrategy strategy) {
        this.strategy = strategy;
    }
 
    /**
     * �����ǿ�����ʱ���, changeһ�¾ͺ���
     */
    public DragonSlayer changeStrategy(DragonSlayingStrategy strategy) {
        this.strategy = strategy;
        return this;
    }
 
    /**
     * ʹ�õ�ǰ������ִ������
     */
    public void goToBattle() {
        this.strategy.execute();
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ��һ��������ʿ
        DragonSlayer slayer = new DragonSlayer();
 
        System.out.println("\n����������");
 
        slayer.goToBattle();
 
        /*-************���簲����Ƭ��**************-*/
 
        System.out.println("\n����������!");
 
        //������ʿ���ֿ����û������, ���ǻ��˻�������, ���й���
        slayer.changeStrategy(new FireStrategy()).goToBattle();
 
        /*-************���簲����Ƭ��**************-*/
 
        System.out.println("\nԶ�ž���������!");
 
        // ����̫ǿ����, ֻ��װ������ħ���������, Ȼ�󹥻�
        slayer.changeStrategy(new SpellStrategy()).goToBattle();
 
        /*-************���簲����Ƭ��**************-*/
 
        System.out.println("\nħ��������");
 
        // ������ʿ�ù������в���, �ֳ�ѧ����һ���µļ���, ��û���ü������������������, ����Ҫ��, ����
        slayer.changeStrategy(new DragonSlayingStrategy() {
            @Override
            public void execute() {
                System.out.println("���ؼ���: �����һ�״���������Ʒ�, ��������!");
            }
        }).goToBattle();
 
        /*-************���簲����Ƭ��**************-*/
        System.out.println("\n����������");
 
        // ������ʿ���ú���ʽ��̷�����һ���µ�����ʽ: ϴ��
        slayer.changeStrategy(()-> System.out.println("ϴ�Բ���: ϴ��~~~~~~")).goToBattle();
	}

}
