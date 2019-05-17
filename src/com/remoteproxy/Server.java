package com.remoteproxy;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
	private static final String HOST = "localhost";
    private static final int PORT = 9090;
 
    public static void main(String args[]) {
 
        try {
            //����2������, ׼�����������������ΪԶ�̶���ע��
            CompareHelper stringCompareHelper = new StringCompare();
            CompareHelper integerCompareHelper = new IntegerCompare();
 
            LocateRegistry.createRegistry(PORT);
 
            //�󶨵�URL��׼��ʽΪ��rmi://host:port/name(����Э��������ʡ�ԣ���������д��������ȷ�ģ�
            // �������о��� "rmi://localhost:9090/XXXXXXCompareHelper"
            Naming.bind("rmi://" + HOST + ":" + PORT + "/StringCompareHelper", stringCompareHelper);
            Naming.bind("//" + HOST + ":" + PORT + "/IntegerCompareHelper", integerCompareHelper);
 
            System.out.println("---->Զ�̶���󶨳ɹ���");
        } catch (RemoteException e) {
            System.out.println("����Զ�̶������쳣��");
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            System.out.println("�����ظ��󶨶����쳣��");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("����URL�����쳣��");
            e.printStackTrace();
        }
    }
	
}
