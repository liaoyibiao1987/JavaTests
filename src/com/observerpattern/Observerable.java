package com.observerpattern;

/***
 * ���󱻹۲��߽ӿ� ��������ӡ�ɾ����֪ͨ�۲��߷���
 *
 */
public interface Observerable {

	public void registerObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObserver();

}