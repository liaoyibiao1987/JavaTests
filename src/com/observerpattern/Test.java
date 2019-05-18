package com.observerpattern;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WechatServer server = new WechatServer("刘德华看电影");
	        
	        Observer userZhang = new WeChatUser("张三");
	        Observer userLi = new WeChatUser("李四");
	        Observer userWang = new WeChatUser("王五");
	        
	        server.registerObserver(userZhang);
	        server.registerObserver(userLi);
	        server.registerObserver(userWang);
	        server.notifyMessage("PHP是世界上最好用的语言！");
	        
	        System.out.println("----------------------------------------------");
	        
	        WechatServer server2 = new WechatServer("张三丰看电影");
	        server2.registerObserver(userZhang);
	        server2.registerObserver(userLi);
	        server2.notifyMessage("JAVA是世界上最好用的语言！");
	}

}
