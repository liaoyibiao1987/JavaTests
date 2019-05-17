package com.remoteproxy;

import java.rmi.*;
import java.rmi.RemoteException;

public interface CompareHelper<T> extends Remote {
	/**
     * 比较 object1 和 object2 的大小,
     * 如果object1大, 那么返回true
     * 如果object2大, 那么返回false
     */
    boolean compare(T object1, T object2) throws RemoteException;
 
    /**
     * 将object2的值连接到object1的后面
     */
    T append(T object1, T object2) throws RemoteException;
}
