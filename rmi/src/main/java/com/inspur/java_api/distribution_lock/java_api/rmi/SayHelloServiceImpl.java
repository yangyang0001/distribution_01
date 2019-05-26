package com.inspur.java_api.distribution_lock.java_api.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * User: YANG
 * Date: 2019/5/22-19:24
 * Description: No Description
 * UnicastRemoteObject 这个类表示这个类是一个远程服务的一个接口
 */
public class SayHelloServiceImpl extends UnicastRemoteObject implements SayHelloService {

    protected SayHelloServiceImpl() throws RemoteException {
    }

    @Override
    public String sayHello(String name) throws Exception {
        return "Hello " + name;
    }
}
