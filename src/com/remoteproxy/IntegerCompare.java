package com.remoteproxy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class IntegerCompare extends UnicastRemoteObject implements CompareHelper<Integer> {

	protected IntegerCompare() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean compare(Integer object1, Integer object2) throws RemoteException {
		// TODO Auto-generated method stub
		return object1 - object2 > 0;
	}

	@Override
	public Integer append(Integer object1, Integer object2) throws RemoteException {
		// TODO Auto-generated method stub
		return object1 + object2;
	}

}
