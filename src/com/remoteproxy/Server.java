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
            //创建2个对象, 准备将这个两个对象作为远程对象注册
            CompareHelper stringCompareHelper = new StringCompare();
            CompareHelper integerCompareHelper = new IntegerCompare();
 
            LocateRegistry.createRegistry(PORT);
 
            //绑定的URL标准格式为：rmi://host:port/name(其中协议名可以省略，下面两种写法都是正确的）
            // 本例子中就是 "rmi://localhost:9090/XXXXXXCompareHelper"
            Naming.bind("rmi://" + HOST + ":" + PORT + "/StringCompareHelper", stringCompareHelper);
            Naming.bind("//" + HOST + ":" + PORT + "/IntegerCompareHelper", integerCompareHelper);
 
            System.out.println("---->远程对象绑定成功！");
        } catch (RemoteException e) {
            System.out.println("创建远程对象发生异常！");
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            System.out.println("发生重复绑定对象异常！");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("发生URL畸形异常！");
            e.printStackTrace();
        }
    }
	
}
