package com.observerpattern;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WechatServer server = new WechatServer("���»�����Ӱ");
	        
	        Observer userZhang = new WeChatUser("����");
	        Observer userLi = new WeChatUser("����");
	        Observer userWang = new WeChatUser("����");
	        
	        server.registerObserver(userZhang);
	        server.registerObserver(userLi);
	        server.registerObserver(userWang);
	        server.notifyMessage("PHP������������õ����ԣ�");
	        
	        System.out.println("----------------------------------------------");
	        
	        WechatServer server2 = new WechatServer("�����ῴ��Ӱ");
	        server2.registerObserver(userZhang);
	        server2.registerObserver(userLi);
	        server2.notifyMessage("JAVA������������õ����ԣ�");
	}

}
