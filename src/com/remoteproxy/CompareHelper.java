package com.remoteproxy;

import java.rmi.*;
import java.rmi.RemoteException;

public interface CompareHelper<T> extends Remote {
	/**
     * �Ƚ� object1 �� object2 �Ĵ�С,
     * ���object1��, ��ô����true
     * ���object2��, ��ô����false
     */
    boolean compare(T object1, T object2) throws RemoteException;
 
    /**
     * ��object2��ֵ���ӵ�object1�ĺ���
     */
    T append(T object1, T object2) throws RemoteException;
}
