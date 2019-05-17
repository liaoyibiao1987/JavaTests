package com.remoteproxy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringCompare extends UnicastRemoteObject implements CompareHelper<String> {

	protected StringCompare() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean compare(String object1, String object2) throws RemoteException {
		// TODO Auto-generated method stub
		return object1.compareTo(object2) == 0;
	}

	@Override
	public String append(String object1, String object2) throws RemoteException {
		// TODO Auto-generated method stub
		return object1 + object2;
	}

}
