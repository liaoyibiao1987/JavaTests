package com.observerpattern;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xml.internal.resolver.helpers.Debug;

public class WechatServer implements Observerable {
	private List<Observer> listObserver;
	// �ص��������������ݲ�����ֱ�Ӹ�Observerable��Ϊ�ӿ�ʹ�ã�notifyObserver(string str)��
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
		System.out.println("������  " + publicName + "˵�� " + str);
		notifyObserver();
	}
}
