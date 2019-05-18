package com.observerpattern;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xml.internal.resolver.helpers.Debug;

public class WechatServer implements Observerable {
	private List<Observer> listObserver;
	// 特点就在这里，传入数据并不是直接给Observerable作为接口使用（notifyObserver(string str)）
	private String message;
	private String publicName;

	public WechatServer(String name) {
		publicName = name;
		listObserver = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		if (listObserver.contains(o) == false) {
			listObserver.add(o);
		}
	}

	@Override
	public void removeObserver(Observer o) {
		if (listObserver.contains(o) == false) {
			listObserver.remove(o);
		}
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : listObserver) {
			observer.update(message);
		}
	}

	public void notifyMessage(String str) {
		message = str;
		System.out.println("公共号  " + publicName + "说： " + str);
		notifyObserver();
	}
}
