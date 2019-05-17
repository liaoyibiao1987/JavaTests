package com.remoteproxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * �ͻ��˲��ԣ��ڿͻ��˵���Զ�̶����ϵ�Զ�̷����������ؽ����
 */
@SuppressWarnings("unchecked")
public class Client {
	public static void main(String args[]) {
        try {
            CompareHelper compareHelper;
 
            compareHelper = (CompareHelper) Naming.lookup("rmi://localhost:9090/StringCompareHelper");
            System.out.println(compareHelper.append("���", "ɵ���Ŀ���˿"));
            System.out.println(compareHelper.compare("abc", "abc"));
 
            compareHelper = (CompareHelper) Naming.lookup("rmi://localhost:9090/IntegerCompareHelper");
            System.out.println(compareHelper.append(6379, 8080));
            System.out.println(compareHelper.compare(666, 666));
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
