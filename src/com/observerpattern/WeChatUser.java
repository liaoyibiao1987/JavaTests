package com.observerpattern;

public class WeChatUser implements Observer {
	private String name;
    private String message;
    
    public WeChatUser(String name) {
        this.name = name;
    }
    
    
	@Override
	public void update(String message) {
		 this.message = message;
		 System.out.println(name + " 收到推送消息： " + message);
	}

}
