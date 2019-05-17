package com.remoteproxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 客户端测试，在客户端调用远程对象上的远程方法，并返回结果。
 */
@SuppressWarnings("unchecked")
public class Client {
	public static void main(String args[]) {
        try {
            CompareHelper compareHelper;
 
            compareHelper = (CompareHelper) Naming.lookup("rmi://localhost:9090/StringCompareHelper");
            System.out.println(compareHelper.append("你好", "傻掉的卡螺丝"));
            System.out.println(compareHelper.compare("abc", "abc"));
 
            compareHelper = (CompareHelper) Naming.lookup("rmi://localhost:9090/IntegerCompareHelper");
            System.out.println(compareHelper.append(6379, 8080));
            System.out.println(compareHelper.compare(666, 666));
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
